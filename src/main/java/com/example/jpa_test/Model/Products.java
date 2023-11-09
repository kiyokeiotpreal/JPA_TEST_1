package com.example.jpa_test.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Set;
@Entity
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;

    private String productName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    @JsonBackReference
    private Set<Properties> propertiesSet;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    @JsonBackReference
    private Set<ProductDetailPropertyDetails> productDetailPropertyDetailsSet;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Set<Properties> getPropertiesSet() {
        return propertiesSet;
    }

    public void setPropertiesSet(Set<Properties> propertiesSet) {
        this.propertiesSet = propertiesSet;
    }

    public Set<ProductDetailPropertyDetails> getProductDetailPropertyDetailsSet() {
        return productDetailPropertyDetailsSet;
    }

    public void setProductDetailPropertyDetailsSet(Set<ProductDetailPropertyDetails> productDetailPropertyDetailsSet) {
        this.productDetailPropertyDetailsSet = productDetailPropertyDetailsSet;
    }
}
