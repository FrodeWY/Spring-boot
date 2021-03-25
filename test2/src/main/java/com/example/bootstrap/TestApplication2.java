package com.example.bootstrap;

import com.example.config.WebConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Mono;


public class TestApplication2 {

    public static void main(String[] args) {
        SpringApplication.run(WebConfiguration.class, args);
    }

}
