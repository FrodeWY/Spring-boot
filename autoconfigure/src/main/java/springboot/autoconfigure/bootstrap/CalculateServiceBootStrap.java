package springboot.autoconfigure.bootstrap;


import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import springboot.autoconfigure.service.CalculateService;

/**
 * profile 条件装配
 */
@SpringBootApplication(scanBasePackages = "springboot.autoconfigure.service")
public class CalculateServiceBootStrap {

  public static void main(String[] args) {
    ConfigurableApplicationContext context = new SpringApplicationBuilder(
        CalculateServiceBootStrap.class)
        .web(WebApplicationType.NONE)
        .profiles("java8")
        .run(args);


    CalculateService calculateService = context
        .getBean(CalculateService.class);

    System.out.println("calculateService sum"+calculateService.sum(1,2,3,4,5,6,7,8,9));
    context.close();
  }

}
