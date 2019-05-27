package demo;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * 对象注册与依赖绑定
 * BeanFactory的功能与职责主要是对象注册与依赖绑定。
 * Spring提供了三种方式来实现对象注册与依赖绑定过程。
 * （1）直接编码方式
 * 首先需要通过BeanFactory来创建一个IoC容器，
 * 然后通过BeanDefinitionRegistry将bean注册到容器当中（而DefaultListableBeanFactory是上述两接口的具体实现类），
 * 最后可通过构造注入或者setter注入方式完成对象间关系的依赖绑定。
 */
public class BeanFactoryRegistryDemo {

  public static void main(String[] args) {
    BeanDefinitionRegistry registry=new DefaultListableBeanFactory();
    BeanFactory beanFactory = bindBeanByCode(registry);
    CommentService commentService = beanFactory.getBean("commentService", CommentService.class);
    System.out.println(commentService.getCount());
    System.out.println(commentService.getBaseCount());
  }

  public static BeanFactory bindBeanByCode(BeanDefinitionRegistry registry){
    //先将Bean抽象成BeanDefinition
    RootBeanDefinition commentDaoBD = new RootBeanDefinition(CommentDao.class);
    RootBeanDefinition commentServiceBD = new RootBeanDefinition(CommentService.class);
    RootBeanDefinition baseDaoBD = new RootBeanDefinition(BaseDao.class);

    //1 注册：beanRegistry是BeanDefinitionRegistry实现类，可以实现Bean注册功能
    registry.registerBeanDefinition("commentDao",commentDaoBD);
    registry.registerBeanDefinition("baseDao",baseDaoBD);
    registry.registerBeanDefinition("commentService",commentServiceBD);
    //2 依赖绑定：将commnetDao绑定到commnetService当中
    //  (1)通过构造方法注入
    ConstructorArgumentValues constructorArgumentValues=new ConstructorArgumentValues();
    constructorArgumentValues.addIndexedArgumentValue(0,commentDaoBD);
    commentServiceBD.setConstructorArgumentValues(constructorArgumentValues);
    // （2）通过setter方法注入
    MutablePropertyValues propertyValues=new MutablePropertyValues();
    propertyValues.addPropertyValue(new PropertyValue("baseDao",baseDaoBD));
    commentServiceBD.setPropertyValues(propertyValues);
    return (BeanFactory) registry;
  }

}
