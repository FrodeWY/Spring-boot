package com.example.bootstrap.example7;

import org.springframework.stereotype.Component;

//@Component
public class HttpServer implements Server {
    @Override
    public void start() {
        System.out.println("http start");
    }

    @Override
    public void stop() {
        System.out.println("http stop");
    }
}
