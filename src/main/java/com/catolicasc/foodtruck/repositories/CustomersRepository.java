/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.catolicasc.foodtruck.repositories;

import com.catolicasc.foodtruck.ConnectionFactory;
import com.catolicasc.foodtruck.models.Customers;
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
public class CustomersRepository {
    private Connection connection;
    
    public CustomersRepository(){
        connection = new ConnectionFactory().getConnection();
    }
    
    public Customers getCustomersById(Integer customersId){
        
        try{
            String sql = "SELECT ID, NAME, EMAIL, ADDRESS FROM CUSTOMERS WHERE ID = ?";
            PreparedStatement selectStmt = connection.prepareStatement(sql);
            selectStmt.setInt(1, customersId);
            ResultSet resultSet = selectStmt.executeQuery();
            
            Customers customers = null;
            
            if(resultSet.first()) {
                customers = new Customers();
            
                int id = resultSet.getInt("ID");
                String name = resultSet.getString("NAME");
                String email = resultSet.getString("EMAIL");
                String address = resultSet.getString("ADDRESS");

                customers.setId(id);
                customers.setName(name);
                customers.setEmail(email);
                customers.setAddress(address);
            }
            
            return customers;
            
            
        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public ArrayList<Customers> getAllProducts() {
        try{
            ArrayList<Customers> customer = new ArrayList<>();
            
            String sql = "SELECT ID, NAME, EMAIL, ADDRESS FROM CUSTOMERS";
            Statement selectStmt = connection.createStatement();
            ResultSet resultSet = selectStmt.executeQuery(sql);
            while(resultSet.next()) {
                
                int id = resultSet.getInt("ID");
                String name = resultSet.getString("NAME");
                String email = resultSet.getString("EMAIL");
                String address = resultSet.getString("ADDRESS");
                
                Customers customers = new Customers();
                customers.setId(id);
                customers.setName(name);
                customers.setEmail(email);
                customers.setAddress(address);
                
                customer.add(customers);
            }
            
            return customer;
        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
     public Customers add(Customers customers) {
        try {
            String sql = "INSERT INTO CUSTOMERS (NAME, EMAIL, ADDRESS) VALUES (?, ?)";
            PreparedStatement insertStmt = connection.prepareStatement(sql);
            insertStmt.setString(1, customers.getName());
            insertStmt.setString(2, customers.getEmail());
            insertStmt.setString(3, customers.getAddress());
            insertStmt.executeUpdate();
            insertStmt.close();
            
            sql = "SELECT LAST_INSERT_ID() AS ID";
           
            Statement selectStmt = connection.createStatement();
            ResultSet resultSet = selectStmt.executeQuery(sql);
            while(resultSet.next()) {
                Integer id  = resultSet.getInt("ID");
                customers.setId(id);
            }
            selectStmt.close();
            
            return customers;
        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    } 

    public Customers remove(Customers customers) {
        try {
            String sql = "DELETE FROM CUSTOMERS WHERE ID = ?";
            PreparedStatement deleteStmt = connection.prepareStatement(sql);
            
            deleteStmt.setInt(1, customers.getId());
            deleteStmt.setString(2, customers.getName());
            deleteStmt.setString(3, customers.getEmail());
            deleteStmt.setString(4, customers.getAddress());
            
            ResultSet resultSet = deleteStmt.executeQuery();
            
            while(resultSet.next()) {
                customers = new Customers();
            
                int id = resultSet.getInt("ID");
                String name = resultSet.getString("NAME");
                String email = resultSet.getString("EMAIL");
                String address = resultSet.getString("ADDRESS");

                customers.setId(id);
                customers.setName(name);
                customers.setEmail(email);
                customers.setAddress(address);
            }           
            deleteStmt.close();
                       
            return customers;
            
            }catch (SQLException ex) {
            throw new RuntimeException(ex);
         }
    }
    
    public Customers update(Customers customers) {
        try {
            String sql = "UPDATE CUSTOMERS SET = ? ,NAME, ? ,EMAIL, ? ,ADDRESS WHERE ID = ?";
            PreparedStatement updateStmt = connection.prepareStatement(sql);
            updateStmt.setString(1, customers.getName());
            updateStmt.setString(2, customers.getEmail());
            updateStmt.setString(3, customers.getAddress());
            updateStmt.setInt(4, customers.getId());
            updateStmt.executeUpdate();
            updateStmt.close();
        
            return customers;
        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    } 
}