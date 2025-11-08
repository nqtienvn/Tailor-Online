package com.tien.tai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
        "com.tien.common",
        "com.tien.tai"
})
public class CustomerServiceApplicationSpringBoot {
    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplicationSpringBoot.class, args);
    }
}