package com.app.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@NoArgsConstructor
@Entity
@Data
@Table(name = "Price")
public class Price {

    @Column(name = "BRAND_ID")
    private int brandId;
    @Column(name = "START_DATE")
    private Date startDate;
    @Column(name = "END_DATE")
    private Date endDate;
    @Column(name = "PRICE_LIST")
    private int priceList;
    @Column(name = "PRODUCT_ID")
    private int productId;
    @Column(name = "PRIORITY")
    private int priority;
    @Column(name = "PRCE")
    private double price;
    @Column(name = "CURR")
    private String currency;


}
