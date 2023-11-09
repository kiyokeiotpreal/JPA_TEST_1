package com.example.jpa_test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class JpaTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(JpaTestApplication.class, args);
    }

}
