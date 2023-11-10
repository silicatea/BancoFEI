/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import javax.swing.JOptionPane;

/**
 *
 * @author Max
 */
public class Clientes {

    private final String url = "jdbc:postgresql://localhost:5432/postgres";
    private final String username = "postgres";
    private final String password = "root";

    /**
     *
     */
    int idCliente = 0;

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    /**
     *
     * @return
     * @throws SQLException
     */
    public Connection connect() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    /**
     *
     * @param cpf
     * @param senha
     * @return
     */
    public boolean fazerLogin(String cpf, String senha) {
        String sq = "SELECT * FROM clientes WHERE cpf=\'%s\' AND senha=\'%s\' LIMIT 1".formatted(cpf, senha);

        boolean success = false;
        try {
            Connection conn = connect();
            Statement smt = conn.createStatement();
            System.out.println("connected");
            ResultSet data = smt.executeQuery(sq);

            if (data.next()) {
                success = true;
                setIdCliente(idCliente);;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return success;
    }

    /**
     *
     * @param valorDebito
     * @param idCliente
     * @param tipoConta
     * @return
     */
    public boolean DebitarConta(double valorDebito, int iec, String tipoConta) {
        //1 - query para ver o quanto que o cara tem na conta
        //2 - Debitar se o valor for menor que o total
        //3 - erro se o valor for maior(não feche a view nesse caso)

        try {
            Connection conn = connect();
            Statement smt = conn.createStatement();
            String sq = "SELECT * FROM contas WHERE id_cliente=%d AND tipo=\'%s\'".formatted(idCliente, tipoConta);

            ResultSet data = smt.executeQuery(sq);
            double saldo = 0;
            while (data.next()) {
                saldo = data.getDouble("saldo");
            }
            System.out.println(saldo);
            
            double tarifa = 0;
            
            switch (tipoConta){
                case "salario":
                    //cobrar 5% de taxa
                    if(saldo < valorDebito){
                        valorDebito = 0;
                        JOptionPane.showMessageDialog(null, "Débito maior do que o saldo disponível na conta. Processo cancelado");
                    }
                    else{
                        valorDebito = valorDebito - (valorDebito * 0.05);
                        tarifa = 5;
                    }
                    break;
                case "corrente":
                    //cobrar 1% de taxa
                    valorDebito = valorDebito - (valorDebito * 0.01);
                    tarifa = 1;
                    break;
                default:
                    if(saldo < valorDebito){
                        JOptionPane.showMessageDialog(null, "Débito maior do que o saldo disponível na conta. Processo cancelado");
                    }
                    break;
            }
            
            String q = "UPDATE contas SET saldo=%.2f WHERE tipo=\'%s\' AND id_cliente=%d".formatted(saldo - valorDebito, tipoConta, idCliente);
            System.out.println(q);
            smt.execute(q);
            String ex = "INSERT INTO extrato(tipo, id_cliente, saldo, tarifa) VALUES (\'%s\',%d, %.2f, %.2f)".formatted("-", idCliente, saldo, tarifa);
            System.out.println(ex);
            smt.execute(ex);
        } catch (SQLException e) {
            System.out.println(e.toString());
        }

        return true;
    }

    /**
     *
     * @param valorDeposito
     * @param tipoConta
     * @return
     */
    public boolean DepositarConta(double valorDeposito, String tipoConta) {
        //1 - query para ver o quanto que o cara tem na conta
        //2 - Debitar se o valor for menor que o total
        //3 - erro se o valor for maior(não feche a view nesse caso)

        try {
            Connection conn = connect();
            Statement smt = conn.createStatement();
            System.out.println("connected");
            String sq = "SELECT * FROM contas WHERE id_cliente=%d AND tipo=\'%s\'".formatted(idCliente, tipoConta);
            System.out.println(sq);
            ResultSet data = smt.executeQuery(sq);
            double saldo = 0;
            while (data.next()) {
                saldo = data.getDouble("saldo");
            }
            
            saldo = saldo + valorDeposito;
            String q = "UPDATE contas SET saldo=%.2f WHERE tipo=\'%s\' AND id_cliente=%d".formatted(saldo, tipoConta, idCliente);
            System.out.println(q);
            smt.execute(q);
            String ex = "INSERT INTO extrato(tipo, id_cliente, saldo, tarifa) VALUES (\'%s\',%d, %.2f, %d)".formatted("+", idCliente, saldo, 0);
            System.out.println(ex);
            smt.execute(ex);
        } catch (SQLException e) {
            System.out.println(e.toString());
        }

        
        return true;
    }

    /**
     *
     * @return
     */
    public ArrayList getAllContas() {
        String sq = "SELECT * FROM contas WHERE id_cliente = %d".formatted(idCliente);
        ArrayList<String> arr = new ArrayList<>();

        boolean success = false;
        try {
            Connection conn = connect();
            Statement smt = conn.createStatement();
            ResultSet data = smt.executeQuery(sq);

            while (data.next()) {
                arr.add(data.getString("tipo"));
            }

            success = true;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return arr;
    }

    /**
     *
     * @return
     */
    public double[] VerSaldo() {
        double[] saldos = new double[3];

        saldos[0] = 0;
        saldos[1] = 0;
        saldos[2] = 0;

        try {
            Connection conn = connect();
            Statement smt = conn.createStatement();
            System.out.println("connected");
            System.out.println(idCliente);
            String sq = "SELECT * FROM contas WHERE id_cliente=%d ORDER BY id ASC".formatted(idCliente);
            System.out.println(sq);
            ResultSet data = smt.executeQuery(sq);
            double saldo = 0;

            int i = 0;
            while (data.next()) {
                saldo = data.getDouble("saldo");
                System.out.println(saldo);
                saldos[i] = saldo;
                i++;
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return saldos;
    }

    /**
     *
     * @return
     */
    public ArrayList GetExtrato() {
        String sq = "SELECT * FROM extrato WHERE id_cliente = %d".formatted(idCliente);
        String cli = "SELECT * FROM clientes WHERE id = %d LIMIT 1".formatted(idCliente);
        
        ArrayList<String> arr = new ArrayList();
        
        try {
            Connection conn = connect();
            Statement smt = conn.createStatement();
            System.out.println("connected");
            
            ResultSet res = smt.executeQuery(cli);
            
            String nome = "";
            String cpf = "";
            while(res.next()){
                nome = res.getString("nome");
                cpf = res.getString("cpf");
            }
            arr.add("Nome: %s\nCPF:%s\nConta: Corrente".formatted(nome, cpf));
            ResultSet data = smt.executeQuery(sq);
            while(data.next()){
                double saldo = data.getDouble("saldo");
                double tarifa = data.getDouble("tarifa");
                String date = data.getString("modified_date");
                String tipo = data.getString("tipo");
                
                String s = "Data:%s  %s  Tarifa: %.2f%%    Saldo: %.2f".formatted(date, tipo, tarifa, saldo);
                arr.add(s);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return arr;
    }
    
    /**
     *
     * @param cliente
     * @return
     */
    public boolean deleteCliente(String cliente){
        String sc = "SELECT * FROM clientes WHERE nome = %s LIMIT 1".formatted(cliente);
        
        boolean success = false;
        try {
            Connection conn = connect();
            Statement smt = conn.createStatement();
            System.out.println("connected");
            ResultSet data = smt.executeQuery(sc);
            
            int id = -1;
            while(data.next()){
                id = data.getInt("id");
            }
            
            if(id != -1){
                String sq = "DELETE FROM clientes WHERE id = %d".formatted(id);
                String sd = "DELETE FROM contas WHERE id_cliente = %d".formatted(id);
        
                boolean ok = smt.execute(sq);
                ok = smt.execute(sd);
                
                success = true;
            }
            
            
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return success;
    }
}
