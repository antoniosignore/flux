package com.asignore.tos;

import com.asignore.tos.service.DatabaseTestHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class FluxApplication {

    @Autowired
    DatabaseTestHelper service;

    public static void main(String[] args) {
        SpringApplication.run(FluxApplication.class, args);
    }

    @PostConstruct
    public void initDatabase() {

        service.initDb();
    }
}
