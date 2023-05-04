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

        PriceDTO myPrice2 = new PriceDTO(1, LocalDateTime.of(2020, 06, 14, 15, 00, 00),
            LocalDateTime.of(2020, 06, 14, 8, 30, 00), 2, 35455, 1, 25.45, "EUR");

        PriceDTO myPrice3 = new PriceDTO(1, LocalDateTime.of(2020, 06, 15, 00, 00, 00),
            LocalDateTime.of(2020, 06, 15, 11, 00, 00), 3, 35455, 1, 30.5, "EUR");

        PriceDTO myPrice4 = new PriceDTO(1, LocalDateTime.of(2020, 06, 15, 16, 00, 00),
            LocalDateTime.of(2020, 12, 30, 23, 59, 59), 4, 35455, 1, 38.95, "EUR");

        myPriceList.add(myPrice1);
        myPriceList.add(myPrice2);
        myPriceList.add(myPrice3);
        myPriceList.add(myPrice4);

        return myPriceList;
    }

    @Test
    public void shouldReturnPriceIfItsWithinRange() {
        PriceService myService = new PriceService(myRepo);

        ArrivingPriceDTO myArrivingPrice = new ArrivingPriceDTO(LocalDateTime.of(2020, 8, 01, 18, 23, 00), 1, 1);


        List<ExitingPriceDTO> myExitList = new ArrayList<>();
        List<PriceDTO> defaultPriceList = gimmePriceList();
            for(PriceDTO myPrice: defaultPriceList){
                ExitingPriceDTO myExitPrice = new ExitingPriceDTO(myPrice.getBrandId(), myPrice.getStartDate(),
                    myPrice.getEndDate(),
                    myPrice.getPriceList(), myPrice.getProductId(), myPrice.getPrice(), myPrice.getCurrency());

                if (myArrivingPrice.getPriceDateTime().isAfter(myPrice.getStartDate())
                    && myArrivingPrice.getPriceDateTime().isBefore(myPrice.getEndDate())) {
                    myExitList.add(myExitPrice);
                }
            }





        assertEquals(myExitList, myService.gimmePrice(myArrivingPrice));

    }

}
