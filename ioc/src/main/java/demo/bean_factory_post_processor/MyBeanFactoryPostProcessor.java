package demo.bean_factory_post_processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * BeanFactoryPostProcessor
 *
 * 在容器启动阶段，BeanFactoryPostProcessor接口允许我们在容器实例化相应对象之前，
 * 对注册到容器的BeanDefinition所保存的信息做相应的修改，比如修改其中bean定义的某些属性，
 * 把bean的scope从singleton改为prototype，也可以把property的值给修改掉，为bean定义增加其他信息等。
 *
 * BeanFactoryPostProcessor是在Spring容器加载了bean的定义文件之后，在bean实例化之前执行的。
 */
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor,Ordered {

  @Override
  public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
    //BeanFactoryPostProcessor发生在读取Bean的BeanDefinition后，Bean实例化之前，所以获取的是BeanDefinition
    BeanDefinition beanDefinition = beanFactory.getBeanDefinition("user");
    //获取bean属性
    MutablePropertyValues propertyValues = beanDefinition.getPropertyValues();
    if (propertyValues.contains("name")) {
      propertyValues.addPropertyValue(new PropertyValue("name", "titi"));
    }
    propertyValues.addPropertyValue("test",1);
  }

  @Override
  public int getOrder() {
    return Ordered.LOWEST_PRECEDENCE;
  }
}
