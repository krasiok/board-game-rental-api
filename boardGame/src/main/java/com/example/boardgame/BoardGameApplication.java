package com.example.boardgame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class BoardGameApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoardGameApplication.class, args);
    }

}
