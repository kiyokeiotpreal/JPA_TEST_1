package com.example.jpa_test.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
public class ProductDetailPropertyDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productDetailPropertyDetailId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "productId", foreignKey = @ForeignKey(name = "fk_Products_ProductDetailPropertyDetails"))
    @JsonManagedReference
    private Products product;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "propertyDetailId", foreignKey = @ForeignKey(name = "fk_PropertyDetails_ProductDetailPropertyDetails"))
    @JsonManagedReference
    private PropertyDetails propertydetails;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "productDetailId", foreignKey = @ForeignKey(name = "fk_ProductDetails_ProductDetailPropertyDetails"))
    @JsonManagedReference
    private ProductDetails productdetail;

    public int getProductDetailPropertyDetailId() {
        return productDetailPropertyDetailId;
    }

    public void setProductDetailPropertyDetailId(int productDetailPropertyDetailId) {
        this.productDetailPropertyDetailId = productDetailPropertyDetailId;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public PropertyDetails getPropertydetails() {
        return propertydetails;
    }

    public void setPropertydetails(PropertyDetails propertydetails) {
        this.propertydetails = propertydetails;
    }

    public ProductDetails getProductdetail() {
        return productdetail;
    }

    public void setProductdetail(ProductDetails productdetail) {
        this.productdetail = productdetail;
    }
}
