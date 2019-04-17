package com.imooc.web.servlet.support;

import com.imooc.web.config.DispatcherServletConfiguration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


/**
 * spring mvc 自动装配 默认实现
 */
public class DefaultAnnotationConfigDispatcherServletInitializer extends
    AbstractAnnotationConfigDispatcherServletInitializer {

  @Override
  //用来配置ContextLoaderListener创建的应用上下文中的bean。,如Jpa数据源等等的配置
  protected Class<?>[] getRootConfigClasses() {
    return new Class[0];
  }

  @Override
//用于定义DispatcherServlet应用上下文中的bean
  protected Class<?>[] getServletConfigClasses() {//DispatcherServlet
    return new Class[]{DispatcherServletConfiguration.class};
  }

  @Override
//指定开始被servlet处理的url,配置从/开始
  protected String[] getServletMappings() {//mapping
    return new String[]{"/"};
  }
}
