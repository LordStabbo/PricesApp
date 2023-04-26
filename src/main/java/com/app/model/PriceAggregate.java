package com.app.model;

import java.util.Date;
import java.util.UUID;

public class PriceAggregate {

    private UUID brandId;
    private Date startDate;
    private Date endDate;
    private int priceList;
    private UUID productId;
    private int priority;
    private double price;
    private String currency;

    public PriceAggregate(UUID brandId, Date startDate, Date endDate, int priceList, UUID productId, int priority,
            double price,
            String currency) {
        this.brandId = brandId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.priceList = priceList;
        this.productId = productId;
        this.priority = priority;
        this.price = price;
        this.currency = currency;
    }
}
