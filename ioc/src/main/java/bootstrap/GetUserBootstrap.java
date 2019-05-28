package bootstrap;

import config.GetBeanConfig;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import pojo.User;

@EnableAutoConfiguration
@ComponentScan(basePackageClasses = GetBeanConfig.class)

public class GetUserBootstrap {


  public static void main(String[] args) {

    ApplicationContext context = new AnnotationConfigApplicationContext(GetUserBootstrap.class);
    User user = context.getBean("user", User.class);
    System.out.println("user.name:" + user.getName());
  }
}
