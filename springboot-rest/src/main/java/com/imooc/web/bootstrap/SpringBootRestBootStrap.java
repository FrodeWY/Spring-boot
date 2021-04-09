package com.imooc.web.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(scanBasePackages = {"com.imooc.web.controller", "com.imooc.web.config"},exclude = DataSourceAutoConfiguration.class)
public class SpringBootRestBootStrap {

  public static void main(String[] args) {
    SpringApplication.run(SpringBootRestBootStrap.class, args);
  }
}
