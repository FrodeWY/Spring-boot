package com.example.config;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Mono;

@Configuration
public class WebConfiguration3 {

    @Bean
    public RouterFunction<ServerResponse> helloWorld() {
        return RouterFunctions.route(RequestPredicates.GET("/hello-world"), new HandlerFunction<ServerResponse>() {
            public Mono<ServerResponse> handle(ServerRequest request) {
                return ServerResponse.ok().body(Mono.just("hello world"), String.class);
            }
        });
    }

    @Bean
    public ApplicationRunner runner(BeanFactory factory) {
        return args -> {
            System.out.println("当前helloWorld bean 实现类为:"+factory.getBean("helloWorld").getClass().getName());
            System.out.println("WebConfiguration2 bean 实现类为:"+factory.getBean(WebConfiguration3.class).getClass().getName());
        };
    }

    //监听web server 已经初始化事件
    @EventListener(WebServerInitializedEvent.class)
    public void onWebServerReady(WebServerInitializedEvent event) {
        System.out.println("当前webServer 实现类:" + event.getWebServer().getClass().getName());
    }
}
