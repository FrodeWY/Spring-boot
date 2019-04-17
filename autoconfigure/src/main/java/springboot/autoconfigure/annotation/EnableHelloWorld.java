package springboot.autoconfigure.annotation;


import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.context.annotation.Import;


/**
 * 模块装配
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
//@Import({HelloWorldConfiguration.class})//@Enable 注解驱动实现 HelloWorldConfiguration->@Configurable->@EnableHellWorld
@Import(HelloWorldImportSelector.class)//@Enable 接口编程实现 HelloWorldConfiguration->HelloWorldImportSelector->@EnableHellWorld
public @interface EnableHelloWorld {

}
