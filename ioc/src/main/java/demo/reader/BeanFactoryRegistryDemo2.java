package demo.reader;

import demo.CommentService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * （2）外部配置文件方式
 * Spring的IoC容器支持两种配置文件格式：
 *
 * Properties文件格式
 * XML文件格式
 *
 * 在这个过程中有个很重要的接口：BeanDefinitionReader。
 * 该接口负责读取配置文件内容并映射到BeanDefinition，然后将BeanDefinition交由BeanDefinitionRegistry 完成Bean的注册与加载。
 *
 * Spring中提供了BeanDefinitionReader的实现类XmlBeanDefinitionReader来读取文件内容，并加载到容器中：
 */
public class BeanFactoryRegistryDemo2 {

  public static void main(String[] args) {
    DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
    BeanFactory container = bindBeanByXml(beanFactory);
    CommentService commentService = container.getBean("commentService", CommentService.class);
    System.out.println(commentService.getBaseCount());
    System.out.println(commentService.getCount());
  }


  public static BeanFactory bindBeanByXml(BeanDefinitionRegistry registry) {
    //读取配置文件内容，解析文件格式，并映射到对应的BeanDefinition，完成注册
    XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(registry);
    xmlBeanDefinitionReader.loadBeanDefinitions("classpath:/application.xml");
    return (BeanFactory) registry;
  }
}
