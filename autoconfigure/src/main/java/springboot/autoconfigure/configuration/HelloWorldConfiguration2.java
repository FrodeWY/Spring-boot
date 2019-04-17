package springboot.autoconfigure.configuration;

import org.springframework.context.annotation.Bean;


/**
 * HelloWorld 配置类 模块装配--接口编程实现
 */
public class HelloWorldConfiguration2 {

  @Bean
  public String helloWorld(){//如果没有配置bean的名称，则方法名即bean的名称
    return "Hello World 2018";
  }

}
