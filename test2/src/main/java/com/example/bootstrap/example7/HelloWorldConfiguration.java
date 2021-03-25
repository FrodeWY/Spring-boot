package com.example.bootstrap.example7;

import org.springframework.context.annotation.Bean;

public class HelloWorldConfiguration {
    @Bean
    public String helloWorld() {
        return "helloWorldBean";
    }
}
