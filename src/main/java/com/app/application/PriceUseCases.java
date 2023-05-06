package com.app.application;

import com.app.infrastructure.persistance.PriceRepository;
import com.app.infrastructure.ui.ArrivingPriceDTO;
import com.app.infrastructure.ui.ExitingPriceDTO;
import com.app.infrastructure.ui.PriceDTO;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class PriceUseCases {

    PriceRepository priceRepo;
    ModelMapper myModelMapper;

    public PriceUseCases(PriceRepository priceRepo, ModelMapper myModelMapper) {
        this.priceRepo = priceRepo;
        this.myModelMapper = myModelMapper;

    }

    public ExitingPriceDTO showPrices(List<PriceDTO> myList, ArrivingPriceDTO myArrivingPrice) {

        PriceDTO comparedPrice = myList.stream()
                .filter(myPrice -> myPrice.getStartDate().isBefore(myArrivingPrice.getPriceDateTime()) &&
                        myPrice.getEndDate().isAfter(myArrivingPrice.getPriceDateTime()))
                .sorted(Comparator.comparing(PriceDTO::getPriority))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("No matching price found"));

        ExitingPriceDTO myExitPrice = new ExitingPriceDTO(comparedPrice.getBrandId(), comparedPrice.getStartDate(),
                comparedPrice.getEndDate(),
                comparedPrice.getPriceList(), comparedPrice.getProductId(), comparedPrice.getPrice(),
                comparedPrice.getCurrency());

        return myExitPrice;
    }

}

// myPrice ->
// myPrice.getData().isAfter(LocalDateTime.of(myPrice.getStartDate)).isBefore(myPrice.getEndDate)
