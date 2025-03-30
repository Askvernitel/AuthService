package com.judge.auth.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * AuthService
 */
@SpringBootApplication(scanBasePackages = "com.judge.auth")
@EnableJpaRepositories(basePackages = "com.judge.auth.repositories")
@EntityScan(basePackages = "com.judge.auth.entities")
@EnableAutoConfiguration
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
