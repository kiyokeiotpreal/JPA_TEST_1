package com.example.jpa_test.Repository;

import com.example.jpa_test.Model.ProductDetailPropertyDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDetailPropertyDetailRepository extends JpaRepository<ProductDetailPropertyDetails, Integer> {
}
