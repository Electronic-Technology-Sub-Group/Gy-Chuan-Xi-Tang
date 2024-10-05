package com.fuze.potryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.fuze"})
public class PotryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PotryServiceApplication.class, args);
    }
}