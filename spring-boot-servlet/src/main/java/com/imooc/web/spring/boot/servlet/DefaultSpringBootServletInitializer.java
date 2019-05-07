package com.imooc.web.spring.boot.servlet;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * {@link SpringBootServletInitializer}默认实现
 *  Spring Boot 应用传统 Servlet 容器部署--> 扩展SpringBootServletInitializer
 */
public class DefaultSpringBootServletInitializer extends SpringBootServletInitializer {

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
    return builder.sources(SpringBootServletBootStrap.class);
  }
}
