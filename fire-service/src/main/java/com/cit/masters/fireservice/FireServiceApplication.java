package com.cit.masters.fireservice;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.*;
import org.springframework.web.client.*;

@SpringBootApplication
public class FireServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FireServiceApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
