package com.springboot.overview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.springboot.overview.web")
public class OverviewApplication {

  public static void main(String[] args) {
//    new SpringApplicationBuilder(OverviewApplication.class)
////        .web(WebApplicationType.NONE)
//        .run(args);
    SpringApplication.run(OverviewApplication.class, args);
  }

}
