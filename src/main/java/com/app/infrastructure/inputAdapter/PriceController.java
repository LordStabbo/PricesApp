package com.app.infrastructure.inputAdapter;

import com.app.application.PriceUseCases;
import com.app.infrastructure.ui.ArrivingPriceDTO;
import com.app.infrastructure.ui.ExitingPriceDTO;
import com.app.infrastructure.ui.PriceDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/prices")
public class PriceController {

    private final PriceUseCases myService;

    public PriceController(PriceUseCases myService) {
        this.myService = myService;
    }

    @GetMapping("/check")
    public ExitingPriceDTO findAllPrices(@RequestBody ArrivingPriceDTO myArrival) {
        List<PriceDTO> myList = gimmePriceList();
        return myService.showPrices(myList, myArrival);
    }

    public List<PriceDTO> gimmePriceList() {
        List<PriceDTO> myPriceList = new ArrayList<PriceDTO>();

        PriceDTO myPrice1 = new PriceDTO(1, LocalDateTime.of(2020, 06, 14, 00, 00,
                00),
                LocalDateTime.of(2020, 12, 31, 23, 59, 59), 1, 35455, 0, 35.5, "EUR");

        PriceDTO myPrice2 = new PriceDTO(1, LocalDateTime.of(2020, 06, 14, 15, 00,
                00),
                LocalDateTime.of(2020, 06, 14, 8, 30, 00), 2, 35455, 1, 25.45, "EUR");

        PriceDTO myPrice3 = new PriceDTO(1, LocalDateTime.of(2020, 06, 15, 00, 00,
                00),
                LocalDateTime.of(2020, 06, 15, 11, 00, 00), 3, 35455, 1, 30.5, "EUR");

        PriceDTO myPrice4 = new PriceDTO(1, LocalDateTime.of(2020, 06, 15, 16, 00,
                00),
                LocalDateTime.of(2020, 12, 30, 23, 59, 59), 4, 35455, 1, 38.95, "EUR");

        myPriceList.add(myPrice1);
        myPriceList.add(myPrice2);
        myPriceList.add(myPrice3);
        myPriceList.add(myPrice4);

        return myPriceList;
    }

}
