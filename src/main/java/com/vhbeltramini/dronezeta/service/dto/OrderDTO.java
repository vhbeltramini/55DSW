package com.vhbeltramini.dronezeta.service.dto;

import com.vhbeltramini.dronezeta.model.Delivery;
import com.vhbeltramini.dronezeta.model.PaymentMethod;
import com.vhbeltramini.dronezeta.model.Product;
import com.vhbeltramini.dronezeta.model.User;
import com.vhbeltramini.dronezeta.model.enums.OrderStatus;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

public class OrderDTO {

    private List<Product> products;

    private Date date;

    private Integer user;

    private PaymentMethod paymentMethod;

    private Delivery delivery;

    private Double totalValue;

    private Integer productsQuantity;


    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    public Integer getProductsQuantity() {
        return productsQuantity;
    }

    public void setProductsQuantity(Integer productsQuantity) {
        this.productsQuantity = productsQuantity;
    }
}
