package com.app.infrastructure.ui;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class PriceBean {

    @Bean
    public ModelMapper myModelMapper() {
        return new ModelMapper();
    }
}
