/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.catolicasc.foodtruck.repositories;

import com.catolicasc.foodtruck.ConnectionFactory;
import com.catolicasc.foodtruck.models.Products;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author brandon.kluck
 */
public class ProductsRepository {
    private Connection connection;
    
    public ProductsRepository(){
        connection = new ConnectionFactory().getConnection();
    }
    
    public Products getProductsById(Integer productsId) {
        try{
            String sql = "SELECT ID, DESCRIPTION, PRICE FROM PRODUCTS WHERE ID = ?";
            PreparedStatement selectStmt = connection.prepareStatement(sql);
            selectStmt.setInt(1, productsId);
            ResultSet resultSet = selectStmt.executeQuery();
            
            Products products = null;
            
            if(resultSet.first()) {
                products = new Products();
            
                int id = resultSet.getInt("ID");
                String description = resultSet.getString("DESCRIPTION");
                Double price = resultSet.getDouble("PRICE");

                products.setId(id);
                products.setDescription(description);
                products.setPrice(price);
            }
            
            return products;
            
            
        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public ArrayList<Products> getAllProducts() {
        try{
            ArrayList<Products> product = new ArrayList<>();
            
            String sql = "SELECT ID, DESCRIPTION, PRICE FROM PRODUCTS";
            Statement selectStmt = connection.createStatement();
            ResultSet resultSet = selectStmt.executeQuery(sql);
            while(resultSet.next()) {
                
                int id = resultSet.getInt("ID");
                String description = resultSet.getString("DESCRIPTION");
                Double price = resultSet.getDouble("PRICE");
                
                Products products = new Products();
                products.setId(id);
                products.setDescription(description);
                products.setPrice(price);
                
                product.add(products);
            }
            
            return product;
        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public Products add(Products products) {
        try {
            String sql = "INSERT INTO PRODUCTS (DESCRIPTION, PRICE) VALUES (?, ?)";
            PreparedStatement insertStmt = connection.prepareStatement(sql);
            insertStmt.setString(1, products.getDescription());
            insertStmt.setDouble(2, products.getPrice());
            insertStmt.executeUpdate();
            insertStmt.close();
            
            sql = "SELECT LAST_INSERT_ID() AS ID";
           
            Statement selectStmt = connection.createStatement();
            ResultSet resultSet = selectStmt.executeQuery(sql);
            while(resultSet.next()) {
                Integer id  = resultSet.getInt("ID");
                products.setId(id);
            }
            selectStmt.close();
            
            return products;
        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
        
    public Products remove(Products products) {
        try {
            String sql = "DELETE FROM PRODUCTS WHERE ID = ?";
            PreparedStatement deleteStmt = connection.prepareStatement(sql);
            
            deleteStmt.setInt(1, products.getId());
            deleteStmt.setString(2, products.getDescription());
            deleteStmt.setDouble(3, products.getPrice());
            
            ResultSet resultSet = deleteStmt.executeQuery();
            
            while(resultSet.next()) {
                products = new Products();
            
                int id = resultSet.getInt("ID");
                String description = resultSet.getString("DESCIPTION");
                Double price = resultSet.getDouble("PRICE");

                products.setId(id);
                products.setDescription(description);
                products.setPrice(price);
            }           
            deleteStmt.close();
                       
            return products;
            
            }catch (SQLException ex) {
            throw new RuntimeException(ex);
         }
    }
    
    public Products update(Products products) {
        try {
            String sql = "UPDATE PRODUCTS SET = ? ,DESCRIPTION, ? ,PRICE WHERE ID = ?";
            PreparedStatement updateStmt = connection.prepareStatement(sql);
            updateStmt.setString(1, products.getDescription());
            updateStmt.setDouble(2, products.getPrice());
            updateStmt.setInt(3, products.getId());
            
            updateStmt.executeUpdate();
            updateStmt.close();
        
            return products;
        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
