package com.app.application;

import com.app.infrastructure.PriceRepository;
import com.app.ui.ArrivingPriceDTO;
import com.app.ui.PriceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class PriceService {

    @Autowired
    PriceRepository priceRepo;

    public PriceService(PriceRepository priceRepo) {
        this.priceRepo = priceRepo;
    }

    public PriceDTO gimmePrices(ArrivingPriceDTO myArrivingPrice) {

        myArrivingPrice = new ArrivingPriceDTO(LocalDateTime.of(2023, 06, 01, 18, 23, 00), 1, 1);

        PriceDTO myPrice = new PriceDTO(1, LocalDateTime.of(2022, 12, 01, 18, 23, 00),
                LocalDateTime.of(2023, 12, 01, 18, 23, 00), 1, 1, 1, 0.0, "ola");

        if (myArrivingPrice.getPriceDateTime().isAfter(myPrice.getStartDate())
                || myArrivingPrice.getPriceDateTime().isBefore(myPrice.getEndDate())) {
            return null;
        } else {
            return myPrice;
        }
    }

    // myPrice ->
    // myPrice.getData().isAfter(LocalDateTime.of(myPrice.getStartDate)).isBefore(myPrice.getEndDate)

}
