package com.app.application;

import com.app.infrastructure.PriceRepository;
import com.app.model.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PriceService {

   @Autowired
    PriceRepository priceRepo;

   Price myPrice = new Price();
   myMapper.map();



    public List<Price> findPrices(Date applicationRange, int productId, int brandId) {
        return null;
    }
}
