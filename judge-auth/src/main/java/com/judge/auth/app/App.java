package com.judge.auth.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * AuthService
 */
@SpringBootApplication(scanBasePackages = "com.judge.auth")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
