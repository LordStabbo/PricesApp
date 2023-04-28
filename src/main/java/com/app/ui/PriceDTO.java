package com.app.ui;

import java.util.Date;
import lombok.Data;

@Data
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
