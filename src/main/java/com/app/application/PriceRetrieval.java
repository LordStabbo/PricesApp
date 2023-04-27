package com.app.application;

import com.app.infrastructure.PriceAggregateDAO;

public class PriceRetrieval {
    private PriceAggregateDAO priceAggregateDAO;

    public PriceRetrieval(PriceAggregateDAO priceAggregateDAO) {
        this.priceAggregateDAO = priceAggregateDAO;

    }

    /*public List<PriceDTO> getPricesFromBrandId(int brandId) {
        ModelMapper myMapper = new ModelMapper();
        return priceAggregateDAO
                .findByBrandId(brandId)
                .stream()
                .map((Price) -> myMapper.map(Price, PriceDTO.class))
                .collect(Collectors.toList());
    }*/
}
