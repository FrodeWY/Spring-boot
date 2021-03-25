package com.example.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Mono;
@SpringBootApplication
public class WebConfiguration {

    @Bean
    public RouterFunction<ServerResponse> helloWorld() {
        return RouterFunctions.route(RequestPredicates.GET("/hello-world"), new HandlerFunction<ServerResponse>() {
            public Mono<ServerResponse> handle(ServerRequest request) {
                return ServerResponse.ok().body(Mono.just("hello world"), String.class);
            }
        });
    }

    //springBoot项目启动时候，有时候需要再启动之后直接执行某一段代码。这个时候就用到了 ApplicationRunner 这个类。
    //UndertowWebServer是Undertow的reactive web实现
/*    @Bean
    public ApplicationRunner runner(WebServerApplicationContext context) {
        return args -> {
            System.out.println("当前webServer 实现类:" + context.getWebServer().getClass().getName());
        };
    }*/
    //监听web server 已经初始化事件
    @EventListener(WebServerInitializedEvent.class)
    public void onWebServerReady(WebServerInitializedEvent event) {
        System.out.println("当前webServer 实现类:" + event.getWebServer().getClass().getName());
    }
}
