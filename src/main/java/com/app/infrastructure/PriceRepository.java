package com.app.infrastructure;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.infrastructure.model.Price;

public interface PriceRepository extends JpaRepository<Price, Integer> {
    List <Price> findByBrandId(int priceId);
}
