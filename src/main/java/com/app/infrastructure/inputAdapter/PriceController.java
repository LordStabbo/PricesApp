package com.app.infrastructure.inputAdapter;

import com.app.application.PriceUseCases;
import com.app.domain.Price;
import com.app.infrastructure.ui.PriceDTO;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/prices")
public class PriceController {

    private PriceUseCases myService;

    public PriceController(PriceUseCases myService) {
        this.myService = myService;
    }

    @GetMapping("/check")
    public List<PriceDTO> findAllPrices(List<Price> myList) {
        return null;
    }

}
