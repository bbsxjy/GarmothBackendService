package com.gbs;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class GarmothApplication {

    public static void main(String[] args) {
        SpringApplication.run(GarmothApplication.class, args);
    }
}