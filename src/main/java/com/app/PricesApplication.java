package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@ComponentScan({ "com.app.infrastructure.*" })
@ComponentScan(basePackages = "com.app.*")
@EnableJpaRepositories("com.app.infrastructure.outputport")
public class PricesApplication {
    public static void main(String[] args) {
        SpringApplication.run(PricesApplication.class, args);
    }
}
