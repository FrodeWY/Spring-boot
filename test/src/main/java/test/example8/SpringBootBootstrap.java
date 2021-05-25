package test.example8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

@EnableAutoConfiguration
public class SpringBootBootstrap {
    public static void main(String[] args) {
        final ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(SpringBootBootstrap.class, args);
        final SpringBootBootstrap bean = configurableApplicationContext.getBean(SpringBootBootstrap.class);
        System.out.println("SpringBootBootstrap bean:"+bean);
    }
}
