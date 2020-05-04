package com.portfolio.app.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
public class PortfolioAppApi {
    public static void main(String[] args) {
        SpringApplication.run(PortfolioAppApi.class, args);
    }
}
