package com.example.jpa_test.Repository;

import com.example.jpa_test.Model.PropertyDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyDetailRepository extends JpaRepository<PropertyDetails, Integer> {
}
