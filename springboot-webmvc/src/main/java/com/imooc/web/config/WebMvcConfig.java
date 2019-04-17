package com.imooc.web.config;

import java.io.File;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.boot.autoconfigure.web.embedded.TomcatWebServerFactoryCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;


/**
 * spring mvc config
 */
@Configuration
//@EnableWebMvc //使用该注解，会使WebMvcAutoConfiguration无法自动装配，使application.properties里的外部化配置无效
public class WebMvcConfig implements WebMvcConfigurer {


  /**
   * viewResolver 使用注解驱动代替xml配置文件
   * @return
   */
  @Bean
  public ViewResolver myViewResolver(){
    InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
    viewResolver.setViewClass(JstlView.class);
    viewResolver.setPrefix("/WEB-INF/jsp/");
    viewResolver.setSuffix(".jsp");
    return viewResolver;
  }
//内容协商
  @Override
  public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
    configurer.favorParameter(true)
        .favorPathExtension(true);
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(new HandlerInterceptor() {
      @Override
      public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
          Object handler) throws Exception {
        System.out.println("拦截中");
        return true;
      }
    });
  }

  @Bean
  public WebServerFactoryCustomizer<TomcatServletWebServerFactory> factoryCustomizer(){
    return (factory)->{
      factory.addContextCustomizers((context -> {
        //相对于user.dir=/Users/wangyang/workspace/learning/diveinspringboot
        String relativePath="springboot-webmvc/src/main/webapp";
        File docBaseFile=new File(relativePath);
        if (docBaseFile.exists()) {//路径是否存在
          //解决maven多模块在ide中jsp无法读取的问题
          context.setDocBase(docBaseFile.getAbsolutePath());
        }
      }));
    };
  }
}
