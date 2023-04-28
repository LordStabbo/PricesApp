package com.app.infrastructure;

import com.app.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PriceRepository extends JpaRepository<Price, Integer> {
    List <Price> findPrices(LocalDateTime applicationRange, int productId, int brandId);
}
