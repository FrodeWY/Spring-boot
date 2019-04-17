package springboot.autoconfigure.annotation;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import springboot.autoconfigure.configuration.HelloWorldConfiguration2;


/**
 * @Enable 模块装配--接口编程实现 HelloWorldConfiguration->HelloWorldImportSelector->@EnableHellWorld
 */
public class HelloWorldImportSelector implements ImportSelector {

  @Override
  public String[] selectImports(AnnotationMetadata importingClassMetadata) {
    return new String[]{HelloWorldConfiguration2.class.getName()};
  }
}
