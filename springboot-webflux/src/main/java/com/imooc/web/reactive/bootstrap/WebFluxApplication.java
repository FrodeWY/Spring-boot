package com.imooc.web.reactive.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.imooc.web.reactive.controller")
public class WebFluxApplication {

  public static void main(String[] args) {
    SpringApplication.run(WebFluxApplication.class, args);
  }


}
