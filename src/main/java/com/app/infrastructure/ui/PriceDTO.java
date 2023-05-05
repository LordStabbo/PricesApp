package com.app.infrastructure.ui;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PriceDTO {

    private int brandId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int priceList;
    private int productId;
    private int priority;
    private double price;
    private String currency;

}
