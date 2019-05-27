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
public class Requests {
    
    private Integer id;
    private Double quantity;
    private Long product_id;
    private Long order_id;
    private Double unit_price;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public void setUnit_price(Double unit_price) {
        this.unit_price = unit_price;
    }

    public Integer getId() {
        return id;
    }

    public Double getQuantity() {
        return quantity;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public Long getOrder_id() {
        return order_id;
    }

    public Double getUnit_price() {
        return unit_price;
    }
    
}
