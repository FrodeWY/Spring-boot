package com.example.bootstrap.test;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableConfigurationProperties(value = CanalMqConfiguration.class)
public class TestBootstrap {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(TestBootstrap.class);
        context.refresh();
        CanalMqConfiguration bean = context.getBean("canalMqConfiguration", CanalMqConfiguration.class);
        System.out.println();
    }
}
