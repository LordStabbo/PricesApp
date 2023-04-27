package com.app.ui;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ArrivingPriceDTO {
    private LocalDateTime priceDateTime;
    private int productId;
    private int brandId;
}
