package com.imooc.web.listener;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ListenerBootstrap {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
        context.register(MyListener.class);
        context.refresh();
        GenericEvent<User> event=new GenericEvent<>(new User("lili"));
//        context.publishEvent(event);
        context.publishEvent(new User("titi"));
        context.close();
    }
}
