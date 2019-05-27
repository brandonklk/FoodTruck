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
public class Products {
    
    private Integer id;
    private String description;
    private Double price;

   
    public void setId(Integer id) {
        this.id = id;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public void setPrice(Double price) {
        this.price = price;
    }
    
    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }
   
}
