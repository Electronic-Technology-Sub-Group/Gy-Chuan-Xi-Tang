package com.fuze.potryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication(scanBasePackages = {"com.fuze"})
public class PotryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PotryServiceApplication.class, args);
    }
}