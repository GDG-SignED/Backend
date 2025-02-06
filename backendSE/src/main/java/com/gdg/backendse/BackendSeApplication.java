package com.gdg.backendse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.gdg.backendse")
public class BackendSeApplication {

    public static void main(String[] args) {

        SpringApplication.run(BackendSeApplication.class, args);
    }
}
