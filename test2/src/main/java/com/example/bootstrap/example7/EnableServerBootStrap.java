package com.example.bootstrap.example7;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@EnableServer(type = ServerTypeEnum.HTTP)
public class EnableServerBootStrap {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EnableServerBootStrap.class);
        Server bean = context.getBean(Server.class);
        bean.start();
        bean.stop();
    }
}
