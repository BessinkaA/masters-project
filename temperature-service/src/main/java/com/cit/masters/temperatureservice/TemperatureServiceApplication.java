package com.cit.masters.temperatureservice;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.*;
import org.springframework.web.client.*;

@SpringBootApplication
public class TemperatureServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TemperatureServiceApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
