package demo.bean_definition_registry_demo.code;

import demo.bean_definition_registry_demo.BaseDao;
import demo.bean_definition_registry_demo.CommentService;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class LoopDenpentDemo {

  public static void main(String[] args) {
    XmlBeanFactory factory=new XmlBeanFactory(new ClassPathResource("./application.xml"));
    CommentService commentService = factory.getBean("commentService", CommentService.class);
    BaseDao baseDao = factory.getBean("baseDao", BaseDao.class);
    System.out.println(commentService.getBaseCount());
    System.out.println(baseDao.getBaseCount());
  }

}
