package com.app.application;

import com.app.domain.Price;
import com.app.infrastructure.outputport.PriceRepository;
import com.app.infrastructure.ui.ArrivingPriceDTO;
import com.app.infrastructure.ui.ExitingPriceDTO;
import com.app.infrastructure.ui.PriceDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PriceUseCases {

    @Autowired
    PriceRepository priceRepo;

    public PriceUseCases(PriceRepository priceRepo) {
        this.priceRepo = priceRepo;

    }

    public ExitingPriceDTO showPrice(ArrivingPriceDTO myArrivingPrice) {

        /*
         * priceRepo.findPrices(myArrivingPrice.getPriceDateTime(),
         * myArrivingPrice.getProductId(),
         * myArrivingPrice.getBrandId());
         */

        PriceDTO myPrice1 = new PriceDTO(1, LocalDateTime.of(2020, 06, 14, 00, 00, 00),
                LocalDateTime.of(2020, 12, 31, 23, 59, 59), 1, 35455, 0, 35.5, "EUR");

        PriceDTO myPrice2 = new PriceDTO(1, LocalDateTime.of(2020, 06, 14, 15, 00, 00),
                LocalDateTime.of(2020, 06, 14, 8, 30, 00), 2, 35455, 1, 25.45, "EUR");

        PriceDTO myPrice3 = new PriceDTO(1, LocalDateTime.of(2020, 06, 15, 00, 00, 00),
                LocalDateTime.of(2020, 06, 15, 11, 00, 00), 3, 35455, 1, 30.5, "EUR");

        PriceDTO myPrice4 = new PriceDTO(1, LocalDateTime.of(2020, 06, 15, 16, 00, 00),
                LocalDateTime.of(2020, 12, 30, 23, 59, 59), 4, 35455, 1, 38.95, "EUR");

        List<PriceDTO> myPriceList = new ArrayList<>();
        myPriceList.add(myPrice1);
        myPriceList.add(myPrice2);
        myPriceList.add(myPrice3);
        myPriceList.add(myPrice4);

        for (PriceDTO myPrice : myPriceList) {
            ExitingPriceDTO myExitPrice = new ExitingPriceDTO(myPrice.getBrandId(), myPrice.getStartDate(),
                    myPrice.getEndDate(),
                    myPrice.getPriceList(), myPrice.getProductId(), myPrice.getPrice(), myPrice.getCurrency());

            if (myArrivingPrice.getPriceDateTime().isAfter(myPrice.getStartDate())
                    && myArrivingPrice.getPriceDateTime().isBefore(myPrice.getEndDate())) {
                return myExitPrice;
            }

        }
        return null;

    }

    public List<Price> getAllPrices() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllPrices'");
    }

}

// myPrice ->
// myPrice.getData().isAfter(LocalDateTime.of(myPrice.getStartDate)).isBefore(myPrice.getEndDate)
