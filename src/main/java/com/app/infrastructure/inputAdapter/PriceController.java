package com.app.infrastructure.inputAdapter;

import com.app.domain.Price;
import com.app.infrastructure.outputport.PriceRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/prices")
public class PriceController {

    private PriceRepository priceRepository;

    @GetMapping("/")
    public List<Price> findAllPrices(List<Price> myList) {
        return priceRepository.findAll();
    }

    @GetMapping("/{price}")
    public ResponseEntity<Price> findPriceByProductId(@PathVariable(value = "BRAND_ID") int brandId) {

        Optional<Price> price = priceRepository.findById(brandId);

        if (price.isPresent()) {
            return ResponseEntity.ok().body(price.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
