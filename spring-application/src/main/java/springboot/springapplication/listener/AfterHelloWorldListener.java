package springboot.springapplication.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.Ordered;

/**
 *  AfterHelloWorldListener {@link ApplicationListener}监听 {@link ContextRefreshedEvent}
 */
public class AfterHelloWorldListener implements ApplicationListener<ContextRefreshedEvent>,
    Ordered {

  @Override
  public void onApplicationEvent(ContextRefreshedEvent event) {
    System.out.println(
        "AfterHelloWorldListener:" + event.getApplicationContext().getId() + ",timestamp:" + event
            .getTimestamp());
  }

  @Override
  public int getOrder() {
    return Ordered.LOWEST_PRECEDENCE;
  }
}
