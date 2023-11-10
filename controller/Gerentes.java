/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import javax.swing.JOptionPane;

/**
 *
 * @author Max
 */
public class Gerentes {

    private final String url = "jdbc:postgresql://localhost:5432/postgres";
    private final String username = "postgres";
    private final String password = "root";

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    public boolean fazerLogin(String cpf, String senha) {
        String sq = "SELECT * FROM gerentes WHERE cpf=\'%s\' AND senha=\'%s\'".formatted(cpf, senha);

        boolean success = false;
        try {
            Connection conn = connect();
            Statement smt = conn.createStatement();
            System.out.println("connected");
            ResultSet data = smt.executeQuery(sq);

            if (data.next()) {
                success = true;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return success;
    }

    public boolean CadastrarCliente(String nome, String senha, String cpf, String tipoConta) {

        String sq = "";
        if (tipoConta == "cliente") {
            sq = "INSERT INTO clientes(nome, senha, cpf) VALUES (\'%s\',\'%s\',\'%s\')".formatted(nome, senha, cpf);
        } else {
            sq = "INSERT INTO gerentes(nome, senha, cpf) VALUES (\'%s\',\'%s\',\'%s\')".formatted(nome, senha, cpf);
        }

        boolean success = false;
        try {
            Connection conn = connect();
            Statement smt = conn.createStatement();
            System.out.println("ok!");
            boolean data = smt.execute(sq);

            System.out.println(data);
            success = true;

        } catch (SQLException e) {
            System.out.println(e);
        }

        return success;
    }

    public boolean CriarConta(String cliente, double saldo, String tipoConta) {
        String sc = "select * from clientes where nome = \'%s\' LIMIT 1".formatted(cliente);

        boolean success = false;
        try {
            Connection conn = connect();
            Statement smt = conn.createStatement();
            System.out.println("ok!");
            ResultSet data = smt.executeQuery(sc);

            int id = -1;
            while (data.next()) {
                id = data.getInt("id");
            }

            String sq = "INSERT INTO contas(id_cliente, saldo, tipo) VALUES (%d,%f,\'%s\')".formatted(id, saldo, tipoConta);
            String sconta = "SELECT * FROM contas WHERE id_cliente = %d AND tipo = \'%s\'".formatted(id, tipoConta);

            int idc = -1;

            data = smt.executeQuery(sconta);
            while (data.next()) {
                idc = data.getInt("id");
            }

            if (idc != -1) {
                JOptionPane.showMessageDialog(null, "A conta já existe[");
                return false;
            }

            smt.execute(sq);
            success = true;
        } catch (SQLException e) {
            System.out.println(e);
        }

        return success;
    }

    public ArrayList getSaldos() {
        String sq = "SELECT * FROM saldos";
        ArrayList<String> arr = new ArrayList<>();
        
        try {
            Connection conn = connect();
            Statement smt = conn.createStatement();
            ResultSet data = smt.executeQuery(sq);
            
            arr.add("CLIENTE - SALDO");
            while (data.next()) {
                String s = "\'%s\' - %.2f".formatted(data.getString("nome"), data.getDouble("total"));
                arr.add(s);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return arr;
    }

    public ArrayList getAllClientes() {
        String sq = "SELECT * FROM clientes";
        ArrayList<String> arr = new ArrayList<>();

        boolean success = false;
        try {
            Connection conn = connect();
            Statement smt = conn.createStatement();
            ResultSet data = smt.executeQuery(sq);

            while (data.next()) {
                arr.add(data.getString("nome"));
            }

            success = true;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return arr;
    }

    public ArrayList getClientesInfo() {
        String sq = "SELECT * FROM clientes";
        ArrayList<String> arr = new ArrayList<>();

        boolean success = false;
        try {
            Connection conn = connect();
            Statement smt = conn.createStatement();
            ResultSet data = smt.executeQuery(sq);

            arr.add("NOME - CPF\n");
            while (data.next()) {
                String s = "";
                s = s.concat(data.getString("nome"));
                s = s.concat(" - ");
                s = s.concat(data.getString("cpf"));
                System.out.println(s);
                arr.add(s);
            }

            success = true;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return arr;
    }

    public boolean ExcluirCliente(String cliente) {
        String x = "SELECT * FROM clientes WHERE nome = \'%s\'".formatted(cliente);

        boolean success = false;
        try {
            Connection conn = connect();
            Statement smt = conn.createStatement();
            System.out.println("ok!");
            
            int id = 0;
            ResultSet t = smt.executeQuery(x);
            while(t.next()){
                id = t.getInt("id");
            }
            String sc = "DELETE FROM contas WHERE id_cliente=%d".formatted(id);
            String sq = "DELETE FROM clientes WHERE id=%d".formatted(id);
            smt.execute(sc);
            smt.execute(sq);
            success = true;

        } catch (SQLException e) {
            System.out.println(e);
        }

        return success;
    }
}
