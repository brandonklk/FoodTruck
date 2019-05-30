/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.catolicasc.foodtruck;

import com.catolicasc.foodtruck.lists.ListCustomers;
import com.catolicasc.foodtruck.lists.ListOrdered;
import com.catolicasc.foodtruck.lists.ListProducts;
import com.catolicasc.foodtruck.lists.ListUsers;

/**
 *
 * @author guilherme
 * @author brandon.kluck
 */
public class MainApp extends javax.swing.JFrame {

    /**
     * Creates new form MainApp
     */
    public MainApp() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openMenuOrdered = new javax.swing.JMenuItem();
        openMenuCustomers = new javax.swing.JMenuItem();
        openMenuProducts = new javax.swing.JMenuItem();
        openMenuUsers = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fileMenu.setMnemonic('f');
        fileMenu.setText("Cadastros");

        openMenuOrdered.setText("Pedidos");
        openMenuOrdered.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenuOrderedActionPerformed(evt);
            }
        });
        fileMenu.add(openMenuOrdered);

        openMenuCustomers.setText("Clientes");
        openMenuCustomers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenuCustomersActionPerformed(evt);
            }
        });
        fileMenu.add(openMenuCustomers);

        openMenuProducts.setText("Produtos");
        openMenuProducts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenuProductsActionPerformed(evt);
            }
        });
        fileMenu.add(openMenuProducts);

        openMenuUsers.setMnemonic('o');
        openMenuUsers.setText("Usuários");
        openMenuUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenuUsersActionPerformed(evt);
            }
        });
        fileMenu.add(openMenuUsers);

        menuBar.add(fileMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void openMenuUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenuUsersActionPerformed
        ListUsers listUsers = new ListUsers();
        
        this.desktopPane.add(listUsers);
        listUsers.setVisible(true);
    }//GEN-LAST:event_openMenuUsersActionPerformed

    private void openMenuProductsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenuProductsActionPerformed
        // TODO add your handling code here:
        ListProducts listProducts = new ListProducts();
        
        this.desktopPane.add(listProducts);
        listProducts.setVisible(true);
    }//GEN-LAST:event_openMenuProductsActionPerformed

    private void openMenuCustomersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenuCustomersActionPerformed
        // TODO add your handling code here:
        ListCustomers listCustomers = new ListCustomers();
        
        this.desktopPane.add(listCustomers);
        listCustomers.setVisible(true);
    }//GEN-LAST:event_openMenuCustomersActionPerformed

    private void openMenuOrderedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenuOrderedActionPerformed
        // TODO add your handling code here:
        ListOrdered  listOrdered = new ListOrdered();
        
        this.desktopPane.add(listOrdered);
        listOrdered.setVisible(true);
    }//GEN-LAST:event_openMenuOrderedActionPerformed

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
            java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainApp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem openMenuCustomers;
    private javax.swing.JMenuItem openMenuOrdered;
    private javax.swing.JMenuItem openMenuProducts;
    private javax.swing.JMenuItem openMenuUsers;
    // End of variables declaration//GEN-END:variables

}
