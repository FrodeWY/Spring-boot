package springboot.autoconfigure.condition;


import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.context.annotation.Conditional;

/**
 * 基于编程方式实现自定义条件装配
 * 根据系统属性做条件判断
 */
@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Conditional(OnSystemProperty.class)
public @interface ConditionalOnSystemProperty {
//系统属性名称
  String name();
//系统属性值
  String value();
}
