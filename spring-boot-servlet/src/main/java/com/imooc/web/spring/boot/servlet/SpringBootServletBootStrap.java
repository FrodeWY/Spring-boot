package com.imooc.web.spring.boot.servlet;

import com.imooc.web.spring.servlet.AsyncServlet;
import java.util.EnumSet;
import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.FilterRegistration.Dynamic;
import javax.servlet.Servlet;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletRegistration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * spring boot 内置容器不支持{@link ServletContainerInitializer} ，不会自动加载{@link WebApplicationInitializer}--->{@link AbstractAnnotationConfigDispatcherServletInitializer}
 * 解决方案：ServletContextInitializer
 */
@EnableAutoConfiguration
//@ServletComponentScan(basePackages = "com.imooc.web.spring.servlet")//spring boot 不完全支持@WebServlet @WebFilter  @WebListener,需要依赖ServletComponentScan
//@ComponentScan(basePackages = "com.imooc.web.spring.servlet.controller")
public class SpringBootServletBootStrap {

  public static void main(String[] args) {
    SpringApplication.run(SpringBootServletBootStrap.class, args);
  }

  /**
   * 也可以使用ServletRegistrationBean 注册servlet
   * @return
   */
  @Bean
  @Order(Ordered.HIGHEST_PRECEDENCE)
  public ServletRegistrationBean asyncServletServletRegistrationBean() {
    //ServletRegistrationBean默认支持异步
    //    registrationBean.setAsyncSupported(true);
    //相同的servlet 只会被注册一次，如果使用传统servlet容器，由于支持@webServlet 会先注册注解本身定义的servlet，这里再注册一次的话，就不能生效了
    ServletRegistrationBean<Servlet> registrationBean = new ServletRegistrationBean<>(new AsyncServlet(), "/");
    //所以需要重新设置一个servlet名称
    registrationBean.setName("MyAsyncServlet");
    return registrationBean;
  }

  @Bean
  public ServletContextInitializer servletContextInitializer() {
    return servletContext -> {
      //或者使用ServletContextInitializer注册servlet filter
     /* ServletRegistration.Dynamic dynamic = servletContext.addServlet("async-servlet", new AsyncServlet());
      dynamic.addMapping("/async-servlet2");
      dynamic.setAsyncSupported(true);*/
      CharacterEncodingFilter filter = new CharacterEncodingFilter();
      Dynamic registration = servletContext.addFilter("filter", filter);
      registration.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), false, "/");
    };
  }
}
