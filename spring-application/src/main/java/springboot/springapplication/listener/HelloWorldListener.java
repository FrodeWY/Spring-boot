package springboot.springapplication.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * HelloWorldListener {@link ApplicationListener}监听 {@link ContextRefreshedEvent}
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
public class HelloWorldListener implements ApplicationListener<ContextRefreshedEvent> {

  @Override
  public void onApplicationEvent(ContextRefreshedEvent event) {
    System.out.println("helloWord :"+event.getApplicationContext().getId()+",timestamp:"+event.getTimestamp());
  }
}
