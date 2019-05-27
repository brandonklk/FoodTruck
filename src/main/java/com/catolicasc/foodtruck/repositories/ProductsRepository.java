/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.catolicasc.foodtruck.repositories;

import com.catolicasc.foodtruck.ConnectionFactory;
import com.catolicasc.foodtruck.models.Products;
import com.catolicasc.foodtruck.models.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
            String sql = "SELECT ID, DESCRIPTION, PRICE FROM PRODUCT WHERE ID = ?";
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
}
