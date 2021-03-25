package com.example.bootstrap.example7;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@EnableHelloWorld(condition = "helloWorld")
public class EnableHelloWorldBootstrap {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EnableHelloWorldBootstrap.class);
        String helloWorld = context.getBean("helloWorld", String.class);
        System.out.println(helloWorld);
        context.close();
    }
}
