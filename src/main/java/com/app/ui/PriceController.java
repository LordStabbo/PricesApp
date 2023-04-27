package com.app.ui;

import com.app.infrastructure.PriceRepository;
import com.app.model.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/allprices/price")
public class PriceController {
    @Autowired
    private PriceRepository priceRepository;

    @GetMapping
    public List<Price> findAllPrices(){
        return priceRepository.findAll();
    }

    @GetMapping("/{price}")
    public ResponseEntity<Price>
        findPriceByProductId(@PathVariable(value = "BRAND_ID") int brandId){

        Optional<Price> price = priceRepository.findById(brandId);

        if(price.isPresent()){
            return ResponseEntity.ok().body(price.get());
        }else{
            return ResponseEntity.notFound().build();
        }

    }

}
