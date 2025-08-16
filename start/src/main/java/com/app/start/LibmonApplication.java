package com.app.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = {"com.app.library.repository","com.app.statistic.repository"})
@EntityScan(basePackages = {"com.app.library.entity", "com.app.statistic.entity"})
@SpringBootApplication(scanBasePackages = {"com.app.library", "com.app.statistic", "com.app.start"})
public class LibmonApplication {
    public static void main(String[] args) {
        SpringApplication.run(LibmonApplication.class, args);
    }
}
