package com.example.jpa_test.Repository;

import com.example.jpa_test.Model.ProductDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDetailRepository extends JpaRepository<ProductDetails, Integer> {
}
