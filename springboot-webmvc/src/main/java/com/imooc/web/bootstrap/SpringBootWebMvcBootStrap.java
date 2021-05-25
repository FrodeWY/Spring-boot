package com.imooc.web.bootstrap;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnNotWebApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;

@SpringBootApplication(scanBasePackages = "com.imooc.web",exclude = JpaRepositoriesAutoConfiguration.class)
public class SpringBootWebMvcBootStrap {

  public static void main(String[] args) {
    SpringApplication.run(SpringBootWebMvcBootStrap.class,args);
  }

}
