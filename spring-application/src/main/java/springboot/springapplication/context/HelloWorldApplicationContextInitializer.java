package springboot.springapplication.context;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * 应用上下文初始器（ApplicationContextInitializer）
 * @order或 ordered 决定应用上下文加载顺序
 * @param <C>
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
public class HelloWorldApplicationContextInitializer<C extends ConfigurableApplicationContext> implements ApplicationContextInitializer<C> {

  @Override
  public void initialize(C applicationContext) {
    System.out.println("HelloWorldApplicationContextInitializer.id="+applicationContext.getId());
  }
}
