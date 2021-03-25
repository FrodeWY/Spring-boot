package com.example.bootstrap;

import com.example.config.WebConfiguration;
import com.example.config.WebConfiguration2;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Mono;


public class TestApplication3 {

    public static void main(String[] args) {
        SpringApplication.run(WebConfiguration2.class, args);
    }

}
