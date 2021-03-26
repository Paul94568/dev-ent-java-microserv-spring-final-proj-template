package com.hinkmond.finalproj.repositories;

import com.hinkmond.finalproj.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findProductByProductNameContains(String name);
}
