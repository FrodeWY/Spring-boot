package springboot.autoconfigure.bootstrap;


import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import springboot.autoconfigure.annotation.EnableHelloWorld;

@EnableHelloWorld//@Enable 模块装配
public class HelloWorldBootStrap {

  public static void main(String[] args) {
    ConfigurableApplicationContext context = new SpringApplicationBuilder(
        HelloWorldBootStrap.class)
        .web(WebApplicationType.NONE)
        .run(args);

    String helloWorld = context.getBean("helloWorld", String.class);
    System.out.println("helloWorld Bean :"+helloWorld);
    context.close();
  }
}
