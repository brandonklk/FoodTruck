/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.catolicasc.foodtruck.lists;

import com.catolicasc.foodtruck.change.AddEditOrdered;
import com.catolicasc.foodtruck.models.Ordered;
import com.catolicasc.foodtruck.repositories.OrderedRepository;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author brandon.kluck
 */

public class ListOrdered extends javax.swing.JInternalFrame {

    private OrderedRepository orderedRepository = new OrderedRepository();
    
    /**
     * Creates new form ListOrdered
     */
    public ListOrdered() {
        initComponents();
    }
    
    public void refreshOrderedList() {
        DefaultTableModel tableModel = (DefaultTableModel) jtOrdered.getModel();
        tableModel.setRowCount(0);
        
        ArrayList<Ordered> ordereds = orderedRepository.getAllOrdered();
        
        for(Ordered ordered : ordereds) {
            tableModel.addRow(new Object[] { 
                ordered.getId(),
                ordered.getQuantity(),
                ordered.getProduct_id(),
                ordered.getOrder_id(),
                ordered.getUnit_price(),
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
        jtOrdered = new javax.swing.JTable();

        jtOrdered.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Quantidade", "Produto", "Pedido", "Preço Unitario"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Double.class, java.lang.Long.class, java.lang.Long.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtOrdered.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jtOrdered);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 614, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 412, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(56, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbAddActionPerformed(java.awt.event.ActionEvent evt) {                                      
        AddEditOrdered addEditOrdered = new AddEditOrdered();
        this.getParent().add(addEditOrdered);
        addEditOrdered.setVisible(true);
    }                                     

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
        refreshOrderedList();
    }                                        

    private void jbRefreshActionPerformed(java.awt.event.ActionEvent evt) {                                          
        refreshOrderedList();
    }                                         

    private void jbUpdateActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
        if(jtOrdered.getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Selecione um pedido");
            return;
        }
        
        Integer rowIndex = jtOrdered.getSelectedRow();
        Integer orderedId = (Integer) jtOrdered.getModel().getValueAt(rowIndex, 0);
        
        Ordered ordered  = orderedRepository.getOrderedById(orderedId);
        
        AddEditOrdered addEditOrdered = new AddEditOrdered();
        addEditOrdered.Ordered(ordered);
        this.getParent().add(addEditOrdered);
        addEditOrdered.setVisible(true);
    } 
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtOrdered;
    // End of variables declaration//GEN-END:variables
}
