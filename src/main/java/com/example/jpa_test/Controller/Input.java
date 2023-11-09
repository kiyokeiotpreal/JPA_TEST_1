package com.example.jpa_test.Controller;

import com.example.jpa_test.Model.Products;

public class Input {
    private Products product;

    private int quantity;

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
