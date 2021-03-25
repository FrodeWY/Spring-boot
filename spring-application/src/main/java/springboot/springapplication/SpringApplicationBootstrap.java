package springboot.springapplication;

import java.util.Collections;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * {@link SpringApplication} 引导类
 */
@SpringBootApplication
public class SpringApplicationBootstrap  {

  public static void main(String[] args) {
    //1.SpringApplication run 需要一个配置源，所以要加@SpringBootApplication，来声明主类是一个配置源，
    // 但并不一定，要主类作为配置源，只要是配置类，都可以作为配置源
//    SpringApplication.run(ApplicationConfiguration.class, args);
//2.SpringApplication Api 自定义SpringApplication
    //准备阶段
    SpringApplication springApplication = new SpringApplication();
    springApplication.setWebApplicationType(WebApplicationType.NONE);
    springApplication.setSources(Collections.singleton(SpringApplicationBootstrap.class.getName()));
    //运行阶段
    springApplication.run(args);

  }

@SpringBootApplication
  public static class ApplicationConfiguration{

  }
}
