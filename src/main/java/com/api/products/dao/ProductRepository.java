package com.api.products.dao;

import java.util.List;

import com.api.products.Entity.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    
    List<Product> findByStatus(Boolean status);
    Product findByName(String name);
}
