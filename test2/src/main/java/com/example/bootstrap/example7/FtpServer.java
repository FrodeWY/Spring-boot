package com.example.bootstrap.example7;

import org.springframework.stereotype.Component;

//@Component
public class FtpServer implements Server {
    @Override
    public void start() {
        System.out.println("ftp start");
    }

    @Override
    public void stop() {
        System.out.println("ftp stop");
    }
}
