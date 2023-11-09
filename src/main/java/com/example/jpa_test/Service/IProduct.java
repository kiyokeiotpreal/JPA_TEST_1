package com.example.jpa_test.Service;

import com.example.jpa_test.Controller.Input;
import com.example.jpa_test.Model.ProductDetails;
import com.example.jpa_test.Model.Products;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IProduct {
    public ResponseEntity<String> buyProduct(Input input);

    public Boolean reviseQuantity(Products product);

    public List<ProductDetails> displayProductDetail();

}
