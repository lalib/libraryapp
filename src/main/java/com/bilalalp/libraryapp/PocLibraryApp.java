package com.bilalalp.libraryapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
public class PocLibraryApp {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(PocLibraryApp.class);
        app.setShowBanner(false);
        app.run(args);
    }
}