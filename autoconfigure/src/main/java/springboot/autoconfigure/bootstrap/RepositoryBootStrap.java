package springboot.autoconfigure.bootstrap;


import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import springboot.autoconfigure.repository.MyFirstLevelRepository;
import springboot.autoconfigure.repository.MySecondLevelRepository;

@ComponentScan(basePackages = "springboot.autoconfigure.repository")
public class RepositoryBootStrap {

  public static void main(String[] args) {
    ConfigurableApplicationContext context = new SpringApplicationBuilder(
        RepositoryBootStrap.class)
        .web(WebApplicationType.NONE)
        .run(args);

    MyFirstLevelRepository myFirstLevelRepository = context
        .getBean("myFirstLevelRepository", MyFirstLevelRepository.class);

    MySecondLevelRepository mySecondLevelRepository = context
        .getBean("mySecondLevelRepository", MySecondLevelRepository.class);

    System.out.println("myFirstLevelRepository Bean"+myFirstLevelRepository);
    System.out.println("mySecondLevelRepository Bean"+mySecondLevelRepository);
    context.close();
  }

}
