package com.app.infrastructure.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "prices")
public class Price {
    @Id private int brandId;
    private Date startDate;
    private Date endDate;
    private int priceList;
    private int productId;
    private int priority;
    private double price;
    private String currency;

    public Price(int brandId, Date startDate, Date endDate, int priceList, int productId, int priority, double price,
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
