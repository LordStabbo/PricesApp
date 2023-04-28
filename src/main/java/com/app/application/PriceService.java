package com.app.application;

import com.app.infrastructure.PriceRepository;
import com.app.model.Price;
import com.app.ui.ArrivingPriceDTO;
import com.app.ui.PriceDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PriceService {

    @Autowired
    PriceRepository priceRepo;

    public PriceService(PriceRepository priceRepo) {
        this.priceRepo = priceRepo;
    }

    public PriceDTO gimmePrices() {

        PriceDTO myPrice = new PriceDTO(1, LocalDateTime.now(), LocalDateTime.now(), 1, 1, 1, 0.0, "ola");
        /*
         * LocalDateTime filteredLocalDate =
         *
         * List<Price> priceList = this.priceRepo.findPrices(myPrice.getStartDate(),
         * myPrice.getProductId(),
         * myPrice.getBrandId());
         * PriceDTO myPriceDTO = new PriceDTO();
         */
        return myPrice;
    }

    // myPrice ->
    // myPrice.getData().isAfter(LocalDateTime.of(myPrice.getStartDate)).isBefore(myPrice.getEndDate)

}
