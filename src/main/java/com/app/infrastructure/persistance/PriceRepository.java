package com.app.infrastructure.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.app.domain.Price;
import com.app.infrastructure.ui.PriceDTO;

import java.util.List;

@Component
public interface PriceRepository extends JpaRepository<PriceDTO, Long> {

    @Query(value = "select * From Prices p", nativeQuery = true)
    List<Price> findPrices(int productId, int brandId);

}
