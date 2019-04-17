package springboot.springapplication.listener;

import org.springframework.boot.context.config.ConfigFileApplicationListener;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * after {@link ConfigFileApplicationListener}事件监听
 * 加载优先级小于ConfigFileApplicationListener，可以读取environment中的属性
 */
public class AfterConfigFileApplicationListener implements SmartApplicationListener {

  @Override
  public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
    return ApplicationEnvironmentPreparedEvent.class.isAssignableFrom(eventType)
        || ApplicationPreparedEvent.class.isAssignableFrom(eventType);
  }

  @Override
  public boolean supportsSourceType(Class<?> aClass) {
    return true;
  }

  @Override
  public void onApplicationEvent(ApplicationEvent event) {

    if (event instanceof ApplicationEnvironmentPreparedEvent) {
      ApplicationEnvironmentPreparedEvent preparedEvent = (ApplicationEnvironmentPreparedEvent) event;
      ConfigurableEnvironment environment = preparedEvent.getEnvironment();
      System.out.println("environment.getProperty:"+environment.getProperty("name"));
    }
    if (event instanceof ApplicationPreparedEvent) {
    }
  }


  @Override
  public int getOrder() {
    return ConfigFileApplicationListener.DEFAULT_ORDER+1;
  }
}
