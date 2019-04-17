package springboot.autoconfigure.bootstrap;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;


@EnableAutoConfiguration//允许自动装配
public class HelloWorldAutoConfigurationBootStrap {

  public static void main(String[] args) {
    ConfigurableApplicationContext context = new SpringApplicationBuilder(
        HelloWorldAutoConfigurationBootStrap.class)
        .web(WebApplicationType.NONE)
        .run(args);
    String helloWorld = context.getBean("helloWorld", String.class);
    System.out.println("auto configuration helloWorld bean:"+helloWorld);
    context.close();
  }

}
