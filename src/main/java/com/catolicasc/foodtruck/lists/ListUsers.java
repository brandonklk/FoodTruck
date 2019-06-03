/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.catolicasc.foodtruck.lists;

import com.catolicasc.foodtruck.change.AddEditProducts;
import com.catolicasc.foodtruck.change.AddEditUser;
import com.catolicasc.foodtruck.models.User;
import com.catolicasc.foodtruck.repositories.UserRepository;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author guilherme
 */

public class ListUsers extends javax.swing.JInternalFrame {

    
    private UserRepository userRepository = new UserRepository();
    
    /**
     * Creates new form ListUsers
     */
    public ListUsers() {
        initComponents();
    }
    
    public void refreshUserList() {
        DefaultTableModel tableModel = (DefaultTableModel) jtUsers.getModel();
        tableModel.setRowCount(0);
        
        ArrayList<User> users = userRepository.getAllUsers();
        
        for(User user : users) {
            tableModel.addRow(new Object[] { 
                user.getId(),
                user.getName(),
                user.getEmail()
            });
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtUsers = new javax.swing.JTable();
        jbRefresh = new javax.swing.JButton();
        jbAdd = new javax.swing.JButton();
        jbUpdate = new javax.swing.JButton();
        jbDelete = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        jtUsers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Email"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtUsers.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jtUsers);

        jbRefresh.setText("Atualizar");
        jbRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbRefreshActionPerformed(evt);
            }
        });

        jbAdd.setText("Adicionar");
        jbAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAddActionPerformed(evt);
            }
        });

        jbUpdate.setText("Alterar");
        jbUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbUpdateActionPerformed(evt);
            }
        });

        jbDelete.setText("Apagar");
        jbDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbRefresh)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbRefresh)
                    .addComponent(jbAdd)
                    .addComponent(jbUpdate)
                    .addComponent(jbDelete))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAddActionPerformed
        AddEditUser addEditUser = new AddEditUser();
        this.getParent().add(addEditUser);
        addEditUser.setVisible(true);
    }//GEN-LAST:event_jbAddActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        refreshUserList();
    }//GEN-LAST:event_formInternalFrameOpened

    private void jbRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbRefreshActionPerformed
        refreshUserList();
    }//GEN-LAST:event_jbRefreshActionPerformed

    private void jbUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbUpdateActionPerformed
        
        if(jtUsers.getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Selecione um usuário");
            return;
        }
        
        Integer rowIndex = jtUsers.getSelectedRow();
        Integer userId = (Integer) jtUsers.getModel().getValueAt(rowIndex, 0);
        
        User user = userRepository.getUserById(userId);
        
        AddEditUser addEditUser = new AddEditUser();
        addEditUser.setUser(user);
        this.getParent().add(addEditUser);
        addEditUser.setVisible(true);
    }//GEN-LAST:event_jbUpdateActionPerformed

    private void jbDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDeleteActionPerformed
        // TODO add your handling code here:
        AddEditUser addEditUser  = new AddEditUser();
        this.getParent().add(addEditUser);
        addEditUser.setVisible(true);
    }//GEN-LAST:event_jbDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAdd;
    private javax.swing.JButton jbDelete;
    private javax.swing.JButton jbRefresh;
    private javax.swing.JButton jbUpdate;
    private javax.swing.JTable jtUsers;
    // End of variables declaration//GEN-END:variables
}
