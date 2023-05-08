package com.app;

import com.app.application.PriceUseCases;
import com.app.infrastructure.persistance.PriceRepository;
import com.app.infrastructure.ui.ArrivingPriceDTO;
import com.app.infrastructure.ui.ExitingPriceDTO;
import com.app.infrastructure.ui.PriceDTO;
import org.junit.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

import static org.mockito.Mockito.*;

public class PriceTest {

    @Autowired
    PriceRepository myRepo;
    ModelMapper myModelMapper;

    public List<PriceDTO> gimmePriceList() {
        PriceDTO price1 = mock(PriceDTO.class);
        when(price1.getStartDate()).thenReturn(LocalDateTime.of(2020, 6, 14, 0, 0, 0));
        when(price1.getEndDate()).thenReturn(LocalDateTime.of(2020, 12, 31, 23, 59, 59));
        when(price1.getPriceList()).thenReturn(1);
        when(price1.getProductId()).thenReturn(35455);
        when(price1.getPriority()).thenReturn(0);
        when(price1.getPrice()).thenReturn(35.5);
        when(price1.getCurrency()).thenReturn("EUR");

        PriceDTO price2 = mock(PriceDTO.class);
        when(price2.getStartDate()).thenReturn(LocalDateTime.of(2020, 6, 14, 15, 0, 0));
        when(price2.getEndDate()).thenReturn(LocalDateTime.of(2020, 6, 14, 8, 30, 0));
        when(price2.getPriceList()).thenReturn(2);
        when(price2.getProductId()).thenReturn(35455);
        when(price2.getPriority()).thenReturn(1);
        when(price2.getPrice()).thenReturn(25.45);
        when(price2.getCurrency()).thenReturn("EUR");

        PriceDTO price3 = mock(PriceDTO.class);
        when(price3.getStartDate()).thenReturn(LocalDateTime.of(2020, 6, 15, 0, 0, 0));
        when(price3.getEndDate()).thenReturn(LocalDateTime.of(2020, 6, 15, 11, 0, 0));
        when(price3.getPriceList()).thenReturn(3);
        when(price3.getProductId()).thenReturn(35455);
        when(price3.getPriority()).thenReturn(1);
        when(price3.getPrice()).thenReturn(30.5);
        when(price3.getCurrency()).thenReturn("EUR");

        PriceDTO price4 = mock(PriceDTO.class);
        when(price4.getStartDate()).thenReturn(LocalDateTime.of(2020, 6, 15, 16, 0, 0));
        when(price4.getEndDate()).thenReturn(LocalDateTime.of(2020, 12, 30, 23, 59, 59));
        when(price4.getPriceList()).thenReturn(4);
        when(price4.getProductId()).thenReturn(35455);
        when(price4.getPriority()).thenReturn(1);
        when(price4.getPrice()).thenReturn(38.95);
        when(price4.getCurrency()).thenReturn("EUR");

        // Create list of mock PriceDTO objects
        List<PriceDTO> myPriceList = new ArrayList<PriceDTO>();
        myPriceList.add(price1);
        myPriceList.add(price2);
        myPriceList.add(price3);
        myPriceList.add(price4);

        return myPriceList;
    }

    List<PriceDTO> myPriceList = gimmePriceList();

    @Test
    public void shouldReturnPriceIfItsWithinRange() {
        PriceUseCases myService = new PriceUseCases(myRepo);

        ArrivingPriceDTO myArrivingPrice = new ArrivingPriceDTO(LocalDateTime.of(2020, 8, 01, 18, 23, 00), 1,
                1);

        List<ExitingPriceDTO> myExitList = new ArrayList<>();
        List<PriceDTO> defaultPriceList = gimmePriceList();
        for (PriceDTO myPrice : defaultPriceList) {
            ExitingPriceDTO myExitPrice = new ExitingPriceDTO(myPrice.getBrandId(),
                    myPrice.getStartDate(),
                    myPrice.getEndDate(),
                    myPrice.getPriceList(), myPrice.getProductId(), myPrice.getPrice(),
                    myPrice.getCurrency());

            if (myArrivingPrice.getPriceDateTime().isAfter(myPrice.getStartDate())
                    && myArrivingPrice.getPriceDateTime().isBefore(myPrice.getEndDate())) {
                myExitList.add(myExitPrice);
            }
        }

        assertEquals(myExitList.get(myExitList.size() - 2), myService.showPrices(myPriceList, myArrivingPrice));

    }

}
