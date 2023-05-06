package com.app.infrastructure.outputport;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.domain.Price;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {

    List<Price> findPrices(LocalDateTime applicationRange, int productId, int brandId);

}
