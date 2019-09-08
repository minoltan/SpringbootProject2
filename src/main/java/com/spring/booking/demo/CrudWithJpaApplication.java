package com.spring.booking.demo;

import org.jsondoc.spring.boot.starter.EnableJSONDoc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableJSONDoc
public class CrudWithJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudWithJpaApplication.class, args);
    }

}
