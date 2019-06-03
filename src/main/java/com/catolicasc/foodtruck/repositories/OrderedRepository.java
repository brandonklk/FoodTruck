/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.catolicasc.foodtruck.repositories;

import java.sql.Connection;
import com.catolicasc.foodtruck.ConnectionFactory;
import com.catolicasc.foodtruck.models.Ordered;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author brandon.kluck
 */
public class OrderedRepository {
    private Connection connection;
    
    public OrderedRepository(){
        connection = new ConnectionFactory().getConnection();
    }
    
    public Ordered getOrderedById(Integer orderedId){
       
        try{
            String sql = "SELECT ID, QUANTITY, PRODUCT_ID, ORDER_ID, UNIT_PRICE FROM ORDERED WHERE ID = ?";
            PreparedStatement selectStmt = connection.prepareStatement(sql);
            selectStmt.setInt(1, orderedId);
            ResultSet resultSet = selectStmt.executeQuery();
            
            Ordered ordered = null;
            
            if(resultSet.first()) {
                ordered = new Ordered();
            
                int id = resultSet.getInt("ID");
                Double quantity = resultSet.getDouble("QUANTITY");
                Long product_id = resultSet.getLong("PRODUCT_ID");
                Long order_id = resultSet.getLong("ORDER_ID");
                Double unit_price = resultSet.getDouble("UNIT_PRICE");

                ordered.setId(id);
                ordered.setQuantity(quantity);
                ordered.setProduct_id(product_id);
                ordered.setOrder_id(order_id);
                ordered.setUnit_price(unit_price);
            }
            
            return ordered;
                      
        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public ArrayList<Ordered> getAllOrdered() {
        try{
            ArrayList<Ordered> ordereds = new ArrayList<>();
            
            String sql = "SELECT ID, QUANTITY, PRODUCT_ID, ORDER_ID, UNIT_PRICE FROM ORDERED";
            Statement selectStmt = connection.createStatement();
            ResultSet resultSet = selectStmt.executeQuery(sql);
            while(resultSet.next()) {
                
                int id = resultSet.getInt("ID");
                Double quantity = resultSet.getDouble("QUANTITY");
                Long product_id = resultSet.getLong("PRODUCT_ID");
                Long order_id = resultSet.getLong("ORDER_ID");
                Double unit_price = resultSet.getDouble("UNIT_PRICE");
                
                Ordered order = new Ordered();
                order.setId(id);
                order.setQuantity(quantity);
                order.setProduct_id(product_id);
                order.setOrder_id(order_id);
                order.setUnit_price(unit_price);
                
                ordereds.add(order);
            }
            
            return ordereds;
        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public Ordered add(Ordered ordered) {
        try {
            String sql = "INSERT INTO ORDERED (QUANTITY, PRODUCT_ID, ORDER_ID, UNIT_PRICE) VALUES (?, ?)";
            PreparedStatement insertStmt = connection.prepareStatement(sql);
            insertStmt.setDouble(1, ordered.getQuantity());
            insertStmt.setLong(2, ordered.getProduct_id());
            insertStmt.setLong(3, ordered.getOrder_id());
            insertStmt.setDouble(4, ordered.getUnit_price());
            insertStmt.executeUpdate();
            insertStmt.close();
            
            sql = "SELECT LAST_INSERT_ID() AS ID";
           
            Statement selectStmt = connection.createStatement();
            ResultSet resultSet = selectStmt.executeQuery(sql);
            while(resultSet.next()) {
                Integer id  = resultSet.getInt("ID");
                ordered.setId(id);
            }
            selectStmt.close();
            
            return ordered;
        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public Ordered remove(Ordered ordereds) {
        try {
            String sql = "DELETE FROM ORDERED WHERE ID = ?";
            PreparedStatement deleteStmt = connection.prepareStatement(sql);
            
            deleteStmt.setInt(1, ordereds.getId());
            deleteStmt.setDouble(2, ordereds.getQuantity());
            deleteStmt.setLong(3, ordereds.getProduct_id());
            deleteStmt.setLong(4, ordereds.getOrder_id());
            deleteStmt.setDouble(5, ordereds.getUnit_price());
            
            ResultSet resultSet = deleteStmt.executeQuery();
            
            while(resultSet.next()) {
                ordereds = new Ordered();
            
                int id = resultSet.getInt("ID");
                Double quantity = resultSet.getDouble("QUANTITY");
                Long product_id = resultSet.getLong("PRODUCT_ID");
                Long order_id = resultSet.getLong("ORDER_ID");
                Double unit_price = resultSet.getDouble("UNIT_PRICE");

                ordereds.setId(id);
                ordereds.setQuantity(quantity);
                ordereds.setProduct_id(product_id);
                ordereds.setOrder_id(order_id);
                ordereds.setUnit_price(unit_price);
            }           
            deleteStmt.close();
                       
            return ordereds;
            
            }catch (SQLException ex) {
            throw new RuntimeException(ex);
         }
    }
    
    public Ordered update(Ordered ordered) {
        try {
            String sql = "UPDATE ORDERED SET = ? ,QUANTITY, ? ,PRODUCT_ID, ? ,ORDER_ID, ? ,UNIT_PRICE WHERE ID = ?";
            PreparedStatement updateStmt = connection.prepareStatement(sql);
            updateStmt.setDouble(1, ordered.getQuantity());
            updateStmt.setLong(2, ordered.getProduct_id());
            updateStmt.setLong(3, ordered.getOrder_id());
            updateStmt.setDouble(4, ordered.getUnit_price());
            updateStmt.setInt(5, ordered.getId());
            
            updateStmt.executeUpdate();
            updateStmt.close();
        
            return ordered;
        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }   
}