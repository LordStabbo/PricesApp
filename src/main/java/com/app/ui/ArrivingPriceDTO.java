package com.app.ui;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor

public class ArrivingPriceDTO {
    private LocalDateTime priceDateTime;
    private int productId;
    private int brandId;
}
