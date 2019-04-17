package com.imooc.web.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.imooc.web.controller")
public class SpringBootRestBootStrap {

  public static void main(String[] args) {
    SpringApplication.run(SpringBootRestBootStrap.class, args);
  }
}
