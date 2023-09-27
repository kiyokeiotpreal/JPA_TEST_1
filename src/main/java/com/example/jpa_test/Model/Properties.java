package com.example.jpa_test.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Properties {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int propertyId;

    private String propertyName;

    private int propertySort;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "productId", foreignKey = @ForeignKey(name = "fk_Product_Properties"))
    @JsonManagedReference
    private Products product;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "properties")
    @JsonBackReference
    private Set<PropertyDetails> propertyDetailsSet;

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public int getPropertySort() {
        return propertySort;
    }

    public void setPropertySort(int propertySort) {
        this.propertySort = propertySort;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public Set<PropertyDetails> getPropertyDetailsSet() {
        return propertyDetailsSet;
    }

    public void setPropertyDetailsSet(Set<PropertyDetails> propertyDetailsSet) {
        this.propertyDetailsSet = propertyDetailsSet;
    }
}
