package com.imooc.configuration.bootstrap;

import com.imooc.configuration.domain.User;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * xml 配置占位符引导类
 */
@SpringBootApplication
public class SpringXmlConfigPlaceHolderBootstrap {

  public static void main(String[] args) {
    String[] locations = {"/META-INF/spring/spring-context.xml", "/META-INF/spring/user-context.xml"};
    ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(locations);
    User user = (User) applicationContext.getBean("user");
    System.err.println("用户对象：" + user);
    applicationContext.close();
  }
}
