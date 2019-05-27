/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.catolicasc.foodtruck.models;

/**
 *
 * @author brandon.kluck
 */
public class Customers {
    
    private Integer id;
    private String name;
    private String email;
    private String address; 

    public void setId(Integer id) {
        this.id = id;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
     public Integer getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
    
    public String getAddress() {
        return address;
    }
 
}