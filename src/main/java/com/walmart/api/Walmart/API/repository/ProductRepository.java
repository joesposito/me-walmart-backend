package com.walmart.api.Walmart.API.repository;

import com.walmart.api.Walmart.API.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    Optional<Product> findByUpc(String upc);
}
