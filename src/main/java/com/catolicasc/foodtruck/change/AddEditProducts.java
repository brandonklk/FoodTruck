/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.catolicasc.foodtruck.change;

import com.catolicasc.foodtruck.models.Products;
import com.catolicasc.foodtruck.repositories.ProductsRepository;
import javax.swing.JOptionPane;

/**
 *
 * @author brandon.kluck
 */
public class AddEditProducts extends javax.swing.JInternalFrame {

    
    private ProductsRepository productsRepository = new ProductsRepository();
    
    private Products products;

    public void setProducts(Products products) {
        this.products = products;
    }
    
    private void updateScreen(Products products) {
        tfID.setText(products.getId().toString());
        tfDesciption.setText(products.getDescription());
        tfPrice.setText(products.getPrice().toString());
    }
       
    /**
     * Creates new form AddEditProducts
     */
    public AddEditProducts() {
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

        jLaber1 = new javax.swing.JLabel();
        jLaber2 = new javax.swing.JLabel();
        jLaber3 = new javax.swing.JLabel();
        tfID = new javax.swing.JTextField();
        tfPrice = new javax.swing.JTextField();
        tfDesciption = new javax.swing.JTextField();
        btSave = new javax.swing.JButton();
        btCancel = new javax.swing.JButton();

        jLaber1.setText("Código:");

        jLaber2.setText("Descrição:");

        jLaber3.setText("Preço:");

        tfID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfIDActionPerformed(evt);
            }
        });

        tfPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPriceActionPerformed(evt);
            }
        });

        tfDesciption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfDesciptionActionPerformed(evt);
            }
        });

        btSave.setText("Salvar");

        btCancel.setText("Cancelar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btCancel)
                        .addGap(29, 29, 29)
                        .addComponent(btSave))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLaber2)
                            .addComponent(jLaber3)
                            .addComponent(jLaber1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfID, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfDesciption, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLaber1)
                    .addComponent(tfID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLaber3)
                    .addComponent(tfPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLaber2)
                    .addComponent(tfDesciption, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSave)
                    .addComponent(btCancel))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tfPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPriceActionPerformed

    private void tfDesciptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDesciptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfDesciptionActionPerformed

    private void tfIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfIDActionPerformed

    private void btCancelActionPerformed(java.awt.event.ActionEvent evt) {                                         
        this.dispose();
    }                                        

    private void btSaveActionPerformed(java.awt.event.ActionEvent evt) {                                       
        try {
            String description = tfDesciption.getText();
            String prices = tfPrice.getText();
            String replaceAll = prices.replaceAll(",", ".");
            Double price = Double.parseDouble(replaceAll);
            
            if (products == null) {
                products = new Products();
                products.setDescription(description);
                products.setPrice(price);
                productsRepository.add(products);
            } else {
                //Atualizar as propriedades do usuário
                //e fazer update do usuário no banco
            }
                       
            updateScreen(products);
            
            JOptionPane.showMessageDialog(null, "Usuário salvo com sucesso!");
            
            this.dispose();
        }catch(Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um problema ao salvar");
        }
    }    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancel;
    private javax.swing.JButton btSave;
    private javax.swing.JLabel jLaber1;
    private javax.swing.JLabel jLaber2;
    private javax.swing.JLabel jLaber3;
    private javax.swing.JTextField tfDesciption;
    private javax.swing.JTextField tfID;
    private javax.swing.JTextField tfPrice;
    // End of variables declaration//GEN-END:variables
}
