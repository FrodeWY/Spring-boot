package springboot.autoconfigure.configuration;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;


/**
 * HelloWorld 配置类  模块装配--注解驱动实现
 */
@Configurable
public class HelloWorldConfiguration {

  @Bean
  public String helloWorld(){//如果没有配置bean的名称，则方法名即bean的名称
    return "Hello World";
  }

}
