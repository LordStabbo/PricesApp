package com.app.infrastructure;

import com.app.infrastructure.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriceRepository extends JpaRepository<Price, Integer> {
    List <Price> findByBrandId(int priceId);
}
