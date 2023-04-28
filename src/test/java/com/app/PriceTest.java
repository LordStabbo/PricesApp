package com.app;

import static org.junit.Assert.assertEquals;
import java.time.LocalDateTime;
import org.junit.Test;
import com.app.application.PriceService;
import com.app.infrastructure.PriceRepository;
import com.app.ui.ArrivingPriceDTO;
import com.app.ui.ExitingPriceDTO;
import com.app.ui.PriceDTO;

public class PriceTest {

    PriceRepository myRepo;

    @Test
    public void shouldReturnPriceIfItsWithinRange() {
        PriceService myService = new PriceService(myRepo);

        ArrivingPriceDTO myArrivingPrice = new ArrivingPriceDTO(LocalDateTime.of(2023, 06, 01, 18, 23, 00), 1, 1);

        PriceDTO myPrice = new PriceDTO(1, LocalDateTime.of(2022, 12, 01, 18, 23, 00),
                LocalDateTime.of(2023, 12, 01, 18, 23, 00), 1, 1, 1, 0.0, "ola");

        ExitingPriceDTO myExitPrice = new ExitingPriceDTO(myPrice.getBrandId(), myPrice.getStartDate(),
                myPrice.getEndDate(),
                myPrice.getPriceList(), myPrice.getProductId(), myPrice.getPrice(), myPrice.getCurrency());

        assertEquals(myExitPrice, myService.gimmePrices(myArrivingPrice));

    }

    @Test
    public void shouldReturnEmptyPriceIfItsNotWithinRange() {
        PriceService myService = new PriceService(myRepo);

        ArrivingPriceDTO myArrivingPrice = new ArrivingPriceDTO(LocalDateTime.of(2020, 06, 01, 18, 23, 00), 1, 1);

        assertEquals(new ExitingPriceDTO(0, null, null, 0, 0, 0.0, null), myService.gimmePrices(myArrivingPrice));

    }

}
