package com.app.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository extends JpaRepository<Price, Integer> {
    List<Price> findByBrandId(int priceId);
}
