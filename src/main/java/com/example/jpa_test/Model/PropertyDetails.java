package com.example.jpa_test.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class PropertyDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int propertyDetailId;

    private String propertyDetailCode;

    private String propertyDetailDetail;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "propertyId", foreignKey = @ForeignKey(name = "fk_Properties_PropertyDetails"))
    @JsonManagedReference
    private Properties properties;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "propertydetails")
    @JsonBackReference
    private Set<ProductDetailPropertyDetails> productDetailPropertyDetailsSet;

    public int getPropertyDetailId() {
        return propertyDetailId;
    }

    public void setPropertyDetailId(int propertyDetailId) {
        this.propertyDetailId = propertyDetailId;
    }

    public String getPropertyDetailCode() {
        return propertyDetailCode;
    }

    public void setPropertyDetailCode(String propertyDetailCode) {
        this.propertyDetailCode = propertyDetailCode;
    }

    public String getPropertyDetailDetail() {
        return propertyDetailDetail;
    }

    public void setPropertyDetailDetail(String propertyDetailDetail) {
        this.propertyDetailDetail = propertyDetailDetail;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public Set<ProductDetailPropertyDetails> getProductDetailPropertyDetailsSet() {
        return productDetailPropertyDetailsSet;
    }

    public void setProductDetailPropertyDetailsSet(Set<ProductDetailPropertyDetails> productDetailPropertyDetailsSet) {
        this.productDetailPropertyDetailsSet = productDetailPropertyDetailsSet;
    }
}
