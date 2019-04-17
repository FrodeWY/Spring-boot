package springboot.autoconfigure.bootstrap;


import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import springboot.autoconfigure.condition.ConditionalOnSystemProperty;

public class ConditionOnSystemPropertyBootStrap {

  @Bean
  @ConditionalOnSystemProperty(name = "user.name",value = "wangyang")
  public String helloWorld(){
    return "hello world";
  }

  public static void main(String[] args) {
    ConfigurableApplicationContext context = new SpringApplicationBuilder(
        ConditionOnSystemPropertyBootStrap.class)
        .web(WebApplicationType.NONE)
        .run(args);
    String helloWorld = context.getBean("helloWorld", String.class);

    System.out.println("helloWorld bean :"+helloWorld);
    context.close();
  }
}
