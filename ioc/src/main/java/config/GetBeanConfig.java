package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pojo.User;

@Configuration
public class GetBeanConfig {


  @Bean
  public User user(){
    return new User();
  }
}
