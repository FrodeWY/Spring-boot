package springboot.autoconfigure.condition;

import java.util.Map;
import java.util.Objects;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 *
 * 自定义条件装配--基于配置方式实现
 * 实现Condition里的matches方法，返回true则进行装配，false则不装配
 */
public class OnSystemProperty implements Condition {

  @Override
  public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

    Map<String, Object> attributes = metadata
        .getAnnotationAttributes(ConditionalOnSystemProperty.class.getName());

    String name = String.valueOf(attributes.get("name"));
    String value = String.valueOf(attributes.get("value"));
    String property = System.getProperty(name);
    return Objects.equals(value,property);
  }
}
