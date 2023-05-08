package com.app.infrastructure.persistance;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.app.application.PriceUseCases;

@Configuration
public class Repositorios {

    @Bean
    public PriceUseCases priceRepo(PriceRepository myRepo) {
        return new PriceUseCases(myRepo);
    }

}
