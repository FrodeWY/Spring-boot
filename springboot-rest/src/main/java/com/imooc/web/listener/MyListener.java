package com.imooc.web.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;

public class MyListener implements ApplicationListener<GenericEvent<User>> {
    @Override
    public void onApplicationEvent(GenericEvent<User> event) {
        System.out.println("onApplicationEvent " + event.getSource());
    }

    @EventListener
    public void eventListener(GenericEvent<User> event) {
        System.out.println("eventListener " + event.getSource());
    }

    @EventListener
    public void eventListener(User user) {
        System.out.println("eventListener user:" + user);
    }
}
