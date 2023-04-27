package com.app.model;

import java.util.List;

public interface PriceAggregateRepository {
    public PriceAggregate findByBrandId(int brandPriceId);
}
