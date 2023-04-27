package com.app.infrastructure;

import com.app.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PriceRepository extends JpaRepository<Price, Integer> {
    List <Price> findPrices(Date applicationRange, int productId, int brandId);
}
