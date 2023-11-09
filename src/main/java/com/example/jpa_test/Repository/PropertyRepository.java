package com.example.jpa_test.Repository;

import com.example.jpa_test.Model.Properties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyRepository extends JpaRepository<Properties, Integer> {
}
