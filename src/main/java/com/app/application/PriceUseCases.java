package com.app.application;

import com.app.infrastructure.outputport.PriceRepository;
import com.app.infrastructure.ui.ArrivingPriceDTO;
import com.app.infrastructure.ui.ExitingPriceDTO;
import com.app.infrastructure.ui.PriceDTO;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PriceUseCases {

    PriceRepository priceRepo;
    ModelMapper myModelMapper;

    public PriceUseCases(PriceRepository priceRepo, ModelMapper myModelMapper) {
        this.priceRepo = priceRepo;
        this.myModelMapper = myModelMapper;

    }

    public List<ExitingPriceDTO> showPrice(ArrivingPriceDTO myArrivingPrice) {

        List<PriceDTO> myPriceList = getAllPrices();

        List<PriceDTO> myFilteredList = myPriceList.stream()
                .filter(myPrice -> myPrice.getStartDate().isBefore(myArrivingPrice.getPriceDateTime()) &&
                        myPrice.getEndDate().isAfter(myArrivingPrice.getPriceDateTime()))
                .collect(Collectors.toList());

        List<ExitingPriceDTO> myExitList = new ArrayList<>();
        for (PriceDTO myPrice : myFilteredList) {
            ExitingPriceDTO myExitPrice = new ExitingPriceDTO(myPrice.getBrandId(), myPrice.getStartDate(),
                    myPrice.getEndDate(),
                    myPrice.getPriceList(), myPrice.getProductId(), myPrice.getPrice(), myPrice.getCurrency());

            myExitList.add(myExitPrice);
        }

        return myExitList;

    }

    public List<PriceDTO> getAllPrices() {
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

        return myPriceList;
    }

}

// myPrice ->
// myPrice.getData().isAfter(LocalDateTime.of(myPrice.getStartDate)).isBefore(myPrice.getEndDate)
