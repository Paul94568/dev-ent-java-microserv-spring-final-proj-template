package com.hinkmond.finalproj.repositories;

import com.hinkmond.finalproj.models.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Integer> {
}