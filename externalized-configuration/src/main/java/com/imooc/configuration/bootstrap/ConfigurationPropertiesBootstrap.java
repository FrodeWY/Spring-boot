package com.imooc.configuration.bootstrap;

import com.imooc.configuration.domain.User2;
import com.imooc.configuration.domain.User3;
import java.util.Locale;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * {@link ConfigurationProperties}注解引导类
 */
@EnableAutoConfiguration
//使用@EnableConfigurationProperties注释后就不需要声明Bean了，可以通过类型找到bean
//value 中放@ConfigurationProperties标注的类
@EnableConfigurationProperties(value = User3.class)
/**
 * 优先级配置
 * Java System Properties -Duser.city.post_code=0731
 * OS Environment Variables USER_CITY_POST_CODE=001
 * application.properties user.city.post-code=0571
 */
public class ConfigurationPropertiesBootstrap {

  public static void main(String[] args) {

    Locale.setDefault(Locale.US);//设置国际化，这里设置为美国
    ConfigurableApplicationContext context = new SpringApplicationBuilder(ConfigurationPropertiesBootstrap.class)
        .web(WebApplicationType.NONE)
        .run(args);
//    User3 user3 = context.getBean("user3",User3.class);
//    User2 user2 = context.getBean("user2", User2.class);
    User3 user3 = context.getBean(User3.class);
//    System.out.println("用户对象2：" + user2);
    System.out.println("用户对象3：" + user3);
    context.close();
  }

/*  @Bean
  public User3 user3() {
    return new User3();
  }*/

  @Bean
  @ConfigurationProperties("user")//也可用于方法上进行属性绑定，但是这个bean就不能使用@EnableConfigurationProperties
  //当存在user.city.post-code属性并且值（havingValue）为555时才会创建这个bean，如果没有这个属性（matchIfMissing）则不创建,这里也支持松散绑定
  //如果使用prefix， prefix+name如果属性在application.properties里不支持松散匹配，必须完全匹配才可以，如果属性在环境变量中，支持松散匹配
  @ConditionalOnProperty(name="user.city.post_code",havingValue = "555",matchIfMissing = false)
  public User2 user2() {
    return new User2();
  }
}
