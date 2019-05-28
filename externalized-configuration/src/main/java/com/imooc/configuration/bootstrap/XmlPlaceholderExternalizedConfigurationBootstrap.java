package com.imooc.configuration.bootstrap;

import com.imooc.configuration.domain.User;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

@ImportResource(value = "/META-INF/spring/user-context.xml")
@EnableAutoConfiguration
public class XmlPlaceholderExternalizedConfigurationBootstrap {

  public static void main(String[] args) {
    ConfigurableApplicationContext context = new SpringApplicationBuilder(XmlPlaceholderExternalizedConfigurationBootstrap.class)
        .web(WebApplicationType.NONE)
        .run(args);
    User user = (User) context.getBean("user");
    System.out.println("用户对象：" + user);
    context.close();
  }
}
