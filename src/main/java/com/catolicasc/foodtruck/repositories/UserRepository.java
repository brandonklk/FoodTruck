/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.catolicasc.foodtruck.repositories;

import com.catolicasc.foodtruck.ConnectionFactory;
import com.catolicasc.foodtruck.models.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author guilherme
 */
public class UserRepository {
    private Connection connection;
    
    public UserRepository() {
        connection = new ConnectionFactory().getConnection();
    }
    
    public User getUserById(Integer userId) {
        try{
            String sql = "SELECT ID, NAME, EMAIL FROM USERS WHERE ID = ?";
            PreparedStatement selectStmt = connection.prepareStatement(sql);
            selectStmt.setInt(1, userId);
            ResultSet resultSet = selectStmt.executeQuery();
            
            User user = null;
            
            if(resultSet.first()) {
                user = new User();
            
                int id = resultSet.getInt("ID");
                String name = resultSet.getString("NAME");
                String email = resultSet.getString("EMAIL");

                user.setId(id);
                user.setName(name);
                user.setEmail(email);
            }
            
            return user;
            
            
        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public ArrayList<User> getAllUsers() {
        try{
            ArrayList<User> users = new ArrayList<>();
            
            String sql = "SELECT ID, NAME, EMAIL FROM USERS";
            Statement selectStmt = connection.createStatement();
            ResultSet resultSet = selectStmt.executeQuery(sql);
            while(resultSet.next()) {
                int id = resultSet.getInt("ID");
                String name = resultSet.getString("NAME");
                String email = resultSet.getString("EMAIL");
                
                User user = new User();
                user.setId(id);
                user.setName(name);
                user.setEmail(email);
                
                users.add(user);
            }
            
            return users;
        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public User add(User user) {
        try {
            String sql = "INSERT INTO USERS (NAME, EMAIL) VALUES (?, ?)";
            PreparedStatement insertStmt = connection.prepareStatement(sql);
            insertStmt.setString(1, user.getName());
            insertStmt.setString(2, user.getEmail());
            insertStmt.executeUpdate();
            insertStmt.close();
            
            sql = "SELECT LAST_INSERT_ID() AS ID";
            Statement selectStmt = connection.createStatement();
            ResultSet resultSet = selectStmt.executeQuery(sql);
            while(resultSet.next()) {
                Integer id  = resultSet.getInt("ID");
                user.setId(id);
            }
            selectStmt.close();
            
            return user;
        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }        
    } 
    public User remove(User user){       
        try {
            String sql = "DELETE FROM USER WHERE ID = ?";
            PreparedStatement deleteStmt = connection.prepareStatement(sql);
            
            deleteStmt.setInt(1, user.getId());
            deleteStmt.setString(2, user.getName());
            deleteStmt.setString(3, user.getEmail());
            deleteStmt.setString(4, user.getAddress());
            
            ResultSet resultSet = deleteStmt.executeQuery();
            
            while(resultSet.next()) {
                
            }
                user = new User();
            
                int id = resultSet.getInt("ID");
                String name = resultSet.getString("NAME");
                String email = resultSet.getString("EMAIL");
                String address = resultSet.getString("ADDRESS");

                user.setId(id);
                user.setName(name);
                user.setEmail(email);
                user.setAddress(address);
            }           
            deleteStmt.close();
                       
            return user;
            
            }catch (SQLException ex) {
            throw new RuntimeException(ex);
         }
}
