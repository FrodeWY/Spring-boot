package com.imooc.web.config;

import com.imooc.web.http.converter.properties.PropertiesHttpMessageConverter;
import com.imooc.web.method.support.PropertiesHandlerMethodArgumentResolver;
import com.imooc.web.method.support.PropertiesHandlerMethodReturnValueHandler;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

@Configuration
public class RestWebMvcConfigurer implements WebMvcConfigurer {

  @Autowired
  private RequestMappingHandlerAdapter requestMappingHandlerAdapter;

  @PostConstruct
  public void init() {
    // 获取当前 RequestMappingHandlerAdapter 所有的 Resolver 对象
    List<HandlerMethodArgumentResolver> resolvers = requestMappingHandlerAdapter.getArgumentResolvers();
    List<HandlerMethodArgumentResolver> newResolvers = new ArrayList<>(resolvers.size() + 1);
    // 添加 PropertiesHandlerMethodArgumentResolver 到集合首位
    newResolvers.add(new PropertiesHandlerMethodArgumentResolver());
    // 添加 已注册的 Resolver 对象集合
    newResolvers.addAll(resolvers);
    // 重新设置 Resolver 对象集合
    requestMappingHandlerAdapter.setArgumentResolvers(newResolvers);

    // 获取当前 HandlerMethodReturnValueHandler 所有的 Handler 对象
    List<HandlerMethodReturnValueHandler> handlers = requestMappingHandlerAdapter.getReturnValueHandlers();
    List<HandlerMethodReturnValueHandler> newHandlers = new ArrayList<>(handlers.size() + 1);
    // 添加 PropertiesHandlerMethodReturnValueHandler 到集合首位
    newHandlers.add(new PropertiesHandlerMethodReturnValueHandler());
    // 添加 已注册的 Handler 对象集合
    newHandlers.addAll(handlers);
    // 重新设置 Handler 对象集合
    requestMappingHandlerAdapter.setReturnValueHandlers(newHandlers);
  }

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**").allowedOrigins("*");
  }

  @Override
  public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
    //不建议添加到末尾,如果前面的HttpMessageConverter 可以处理媒体类型,就无法使用自定义的HttpMessageConverter
//    converters.add(new PropertiesHttpMessageConverter());
    converters.add(0, new PropertiesHttpMessageConverter());//建议放在开头
  }


  @Override
  public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
    //添加自定义的HandlerMethodArgumentResolver,优先级低于内建HandlerMethodArgumentResolver
//    resolvers.add(0,new PropertiesHandlerMethodArgumentResolver());

  }
}
