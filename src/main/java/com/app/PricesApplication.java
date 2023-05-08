package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = { "com.app.*" })
@EntityScan({ "com.app.*" })
@EnableJpaRepositories("com.app.infrastructure.persistence")
public class PricesApplication {
    public static void main(String[] args) {
        SpringApplication.run(PricesApplication.class, args);
    }
}
