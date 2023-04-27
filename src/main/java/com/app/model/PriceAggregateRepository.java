package com.app.model;


public interface PriceAggregateRepository {
    public PriceAggregate findByBrandId(int brandPriceId);
}
