package com.app;

import static org.junit.Assert.assertEquals;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import com.app.application.PriceService;
import com.app.infrastructure.PriceRepository;
import com.app.ui.ArrivingPriceDTO;
import com.app.ui.ExitingPriceDTO;
import com.app.ui.PriceDTO;

public class PriceTest {

    PriceRepository myRepo;

    public List<PriceDTO> gimmePriceList() {
        List<PriceDTO> myPriceList = new ArrayList<PriceDTO>();

        PriceDTO myPrice1 = new PriceDTO(1, LocalDateTime.of(2020, 06, 14, 00, 00, 00),
                LocalDateTime.of(2020, 12, 31, 23, 59, 59), 1, 35455, 0, 35.5, "EUR");
        PriceDTO myPrice2 = new PriceDTO(1, LocalDateTime.of(2022, 12, 01, 18, 23, 00),
                LocalDateTime.of(2023, 12, 01, 18, 23, 00), 1, 1, 1, 0.0, "ola");
        PriceDTO myPrice3 = new PriceDTO(1, LocalDateTime.of(2022, 12, 01, 18, 23, 00),
                LocalDateTime.of(2023, 12, 01, 18, 23, 00), 1, 1, 1, 0.0, "ola");
        PriceDTO myPrice4 = new PriceDTO(1, LocalDateTime.of(2022, 12, 01, 18, 23, 00),
                LocalDateTime.of(2023, 12, 01, 18, 23, 00), 1, 1, 1, 0.0, "ola");
        PriceDTO myPrice5 = new PriceDTO(1, LocalDateTime.of(2022, 12, 01, 18, 23, 00),
                LocalDateTime.of(2023, 12, 01, 18, 23, 00), 1, 1, 1, 0.0, "ola");

        myPriceList.add(myPrice1);
        myPriceList.add(myPrice2);
        myPriceList.add(myPrice3);
        myPriceList.add(myPrice4);
        myPriceList.add(myPrice5);

        return myPriceList;
    }

    @Test
    public void shouldReturnPriceIfItsWithinRange() {
        PriceService myService = new PriceService(myRepo);

        ArrivingPriceDTO myArrivingPrice = new ArrivingPriceDTO(LocalDateTime.of(2023, 06, 01, 18, 23, 00), 1, 1);

        PriceDTO myPrice = new PriceDTO(1, LocalDateTime.of(2022, 12, 01, 18, 23, 00),
                LocalDateTime.of(2023, 12, 01, 18, 23, 00), 1, 1, 1, 0.0, "ola");

        ExitingPriceDTO myExitPrice = new ExitingPriceDTO(myPrice.getBrandId(), myPrice.getStartDate(),
                myPrice.getEndDate(),
                myPrice.getPriceList(), myPrice.getProductId(), myPrice.getPrice(), myPrice.getCurrency());

        List<ExitingPriceDTO> myExitList = new ArrayList<>();
        myExitList.add(myExitPrice);
        assertEquals(myExitList, myService.gimmePrice(myArrivingPrice));

    }

    @Test
    public void shouldReturnEmptyPriceIfItsNotWithinRange() {
        PriceService myService = new PriceService(myRepo);

        ArrivingPriceDTO myArrivingPrice = new ArrivingPriceDTO(LocalDateTime.of(2020, 06, 01, 18, 23, 00), 1, 1);

        assertEquals(new ExitingPriceDTO(0, null, null, 0, 0, 0.0, null), myService.gimmePrice(myArrivingPrice));

    }

    /*
     * @Test
     * public void returnResultsFromABunchOfPrices(List<PriceDTO> myPriceList,
     * ArrivingPriceDTO myArrivingPrice) {
     * PriceService myService = new PriceService(myRepo);
     * myPriceList = gimmePriceList();
     * List<ExitingPriceDTO> myExitList = new ArrayList<>();
     *
     * for (PriceDTO p : myPriceList) {
     * myArrivingPrice = p;
     * ExitingPriceDTO myExitPrice = new ExitingPriceDTO(p.getBrandId(),
     * p.getStartDate(),
     * p.getEndDate(),
     * p.getPriceList(), p.getProductId(), p.getPrice(),
     * p.getCurrency());
     *
     * myExitList.add(myExitPrice);
     * assertEquals(myExitList, myService.gimmePrice(myPriceList, p));
     * }
     *
     *
     * }
     */

}
