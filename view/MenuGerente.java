/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import MenuGerenteItens.CadastrarCliente;
import MenuGerenteItens.CriarConta;
import MenuGerenteItens.ExcluirCliente;
import MenuGerenteItens.ExibirCliente;
import MenuGerenteItens.ExibirContas;
import MenuGerenteItens.ExibirSaldos;
import java.awt.Color;

/**
 *
 * @author Max
 */
public class MenuGerente extends javax.swing.JFrame {

    /**
     * Creates new form MenuGerente
     */
    public MenuGerente() {
        initComponents();
        BTCadastrarCliente.setBackground(Color.white);
        BTCriarConta.setBackground(Color.white);
        BTExcluirCliente.setBackground(Color.white);
        BTExibirContas.setBackground(Color.white);
        BTExibirSaldoClientes.setBackground(Color.white);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        BTExcluirCliente = new javax.swing.JButton();
        BTCadastrarCliente = new javax.swing.JButton();
        BTExibirContas = new javax.swing.JButton();
        BTExibirSaldoClientes = new javax.swing.JButton();
        BTCriarConta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Bem vindo ao Banco FEI!");

        BTExcluirCliente.setText("Excluir clientes");
        BTExcluirCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTExcluirClienteActionPerformed(evt);
            }
        });

        BTCadastrarCliente.setText("Cadastrar clientes");
        BTCadastrarCliente.setOpaque(true);
        BTCadastrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTCadastrarClienteActionPerformed(evt);
            }
        });

        BTExibirContas.setText("Exibir clientes");
        BTExibirContas.setActionCommand("Exibir clientes");
        BTExibirContas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTExibirContasActionPerformed(evt);
            }
        });

        BTExibirSaldoClientes.setText("Exibir Saldos");
        BTExibirSaldoClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTExibirSaldoClientesActionPerformed(evt);
            }
        });

        BTCriarConta.setText("Criar conta");
        BTCriarConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTCriarContaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(100, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BTCriarConta, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTExibirSaldoClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTExibirContas, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTExcluirCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTCadastrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(100, 100, 100))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(BTCadastrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BTExcluirCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BTCriarConta, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BTExibirContas, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BTExibirSaldoClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTCadastrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTCadastrarClienteActionPerformed
        CadastrarCliente cacli = new CadastrarCliente();
        
        cacli.setVisible(true);
    }//GEN-LAST:event_BTCadastrarClienteActionPerformed

    private void BTExcluirClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTExcluirClienteActionPerformed
        ExcluirCliente excli = new ExcluirCliente();
        
        excli.setVisible(true);
    }//GEN-LAST:event_BTExcluirClienteActionPerformed

    private void BTCriarContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTCriarContaActionPerformed
        CriarConta cricon = new CriarConta();
        
        cricon.setVisible(true);
    }//GEN-LAST:event_BTCriarContaActionPerformed

    private void BTExibirContasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTExibirContasActionPerformed
        ExibirCliente excon = new ExibirCliente();
        
        excon.setVisible(true);
    }//GEN-LAST:event_BTExibirContasActionPerformed

    private void BTExibirSaldoClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTExibirSaldoClientesActionPerformed
        ExibirSaldos exsal = new ExibirSaldos();
        
        exsal.setVisible(true);
    }//GEN-LAST:event_BTExibirSaldoClientesActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuGerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuGerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuGerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuGerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuGerente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTCadastrarCliente;
    private javax.swing.JButton BTCriarConta;
    private javax.swing.JButton BTExcluirCliente;
    private javax.swing.JButton BTExibirContas;
    private javax.swing.JButton BTExibirSaldoClientes;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
