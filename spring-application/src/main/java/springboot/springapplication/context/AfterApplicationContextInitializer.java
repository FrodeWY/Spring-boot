package springboot.springapplication.context;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;

/**
 * 应用上下文初始器（ApplicationContextInitializer）
 * after HelloWorldApplicationContextInitializer
 */
public class AfterApplicationContextInitializer implements ApplicationContextInitializer, Ordered {

  @Override
  public void initialize(ConfigurableApplicationContext applicationContext) {
    System.out.println("AfterApplicationContextInitializer.id="+applicationContext.getId());
  }

  /**
   * 定义应用上下文初始器加载顺序
   * @return
   */
  @Override
  public int getOrder() {
    return Ordered.LOWEST_PRECEDENCE;
  }
}
