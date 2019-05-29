package demo.bean_factory_post_processor;

import demo.bean_definition_registry_demo.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.User;

@ComponentScan(basePackageClasses = MyBeanFactoryPostProcessor.class)

public class BeanFactoryPostProcessorBootstrap {


  public static void main(String[] args) {
    ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/context.xml");
    User user = applicationContext.getBean("user", User.class);
    System.out.println("user.name:  " + user.getName());
  }


}
