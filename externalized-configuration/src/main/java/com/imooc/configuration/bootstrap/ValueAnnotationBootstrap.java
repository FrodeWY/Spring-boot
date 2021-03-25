package com.imooc.configuration.bootstrap;

import static org.springframework.context.ConfigurableApplicationContext.ENVIRONMENT_BEAN_NAME;

import com.imooc.configuration.domain.User2;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;

/**
 * {@link  @Value 注解注入}
 */

/**
 * 1. 凡是被spring管理的类，实现接口EnvironmentAware 重写方法 setEnvironment
 * 可以在工程启动时，获取到系统环境变量和application配置文件中的变量。
 *
 * 2.要直接在自己的代码中读取spring的bean,我们除了根据常用的set外,也可以通过spring的BeanFactoryAware接口实现,只要实现setBeanFactory方法就可以
 *
 *
 * */
@EnableAutoConfiguration
public class ValueAnnotationBootstrap implements EnvironmentAware,BeanFactoryAware {

//  private final Environment environment;

  @Autowired //@Autowired 依赖注入，也可以放在get() set()方法
  private Environment environment;

  //构造器依赖注入Environment
/*  public ValueAnnotationBootstrap(Environment environment) {
    this.environment = environment;
  }*/

  //    private final Long id;
//
//    private final String name;
//
//    private final Integer age;
//    //构造器依赖注入
//    public ValueAnnotationBootstrap(@Value("${user.id}") Long id, @Value("${user.name}") String name,
//                                    @Value("${user.age}") Integer age) {
//        this.id = id;
//        this.name = name;
//        this.age = age;
//    }

  @Bean
  //方法依赖注入
  public User2 user(@Value("${user.id:1}") Long id, @Value("${user.name:wy}") String name, @Value("${user.desc:hahah}") String desc,
      @Value("${user.age:${my.user.age:32}}") Integer age) {
    return new User2(id, name, desc, age);
  }

  @Bean
  //spring 会自动将为bean的方法参数自动注入，不需要加@Autowired
  public User2 user2(Environment environment) {
    Long id = environment.getRequiredProperty("user.id", Long.class);
    String name = environment.getRequiredProperty("user.name");
    String desc = environment.getProperty("user.desc", "hello world");
    Integer age = environment.getProperty("user.age", Integer.class, environment.getProperty("my.user.age", Integer.class, 32));
    return new User2(id, name, desc, age);
  }

  @Bean
  public User2 user3() {
    Long id = environment.getRequiredProperty("user.id", Long.class);
    String name = environment.getRequiredProperty("user.name");
    String desc = environment.getProperty("user.desc", "hello world");
    Integer age = environment.getProperty("user.age", Integer.class, environment.getProperty("my.user.age", Integer.class, 32));
    return new User2(id, name, desc, age);
  }

  public static void main(String[] args) {
    ConfigurableApplicationContext context = new SpringApplicationBuilder().web(WebApplicationType.NONE)
        .sources(ValueAnnotationBootstrap.class)
        .run(args);
    User2 user = (User2) context.getBean("user");
    User2 user2 = (User2) context.getBean("user2");
    User2 user3 = (User2) context.getBean("user3");
    System.out.println("用户对象：" + user);
    System.out.println("用户对象2：" + user2);
    System.out.println("用户对象3：" + user3);
    context.close();
  }

  /**
   * 1凡是被spring管理的类，实现接口EnvironmentAware 重写方法 setEnvironment
   *  * 可以在工程启动时，获取到系统环境变量和application配置文件中的变量。
   * @param environment
   */
  @Override
  public void setEnvironment(Environment environment) {
//    this.environment=environment;
    if (this.environment != environment) {
//      ((ConfigurableEnvironment)environment).setActiveProfiles();
      throw new IllegalStateException();
    }
  }

  @Override
  public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
    Environment environment = beanFactory.getBean(ENVIRONMENT_BEAN_NAME, Environment.class);
    if(environment!=this.environment){
      throw new IllegalStateException();
    }
  }
}
