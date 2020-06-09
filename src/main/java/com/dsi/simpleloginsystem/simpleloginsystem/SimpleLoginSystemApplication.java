package com.dsi.simpleloginsystem.simpleloginsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class SimpleLoginSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleLoginSystemApplication.class, args);
    }

}
