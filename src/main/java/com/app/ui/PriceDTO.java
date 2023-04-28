package com.app.ui;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PriceDTO {

    private int brandId;
    private Date startDate;
    private Date endDate;
    private int priceList;
    private int productId;
    private int priority;
    private double price;
    private String currency;

}
