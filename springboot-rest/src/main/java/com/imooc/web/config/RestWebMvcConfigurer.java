package com.imooc.web.config;

import com.imooc.web.http.converter.properties.PropertiesHttpMessageConverter;
import com.imooc.web.method.support.PropertiesHandlerMethodArgumentResolver;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

@Configuration
public class RestWebMvcConfigurer implements WebMvcConfigurer {

  @Autowired
  private RequestMappingHandlerAdapter requestMappingHandlerAdapter;

  @PostConstruct
  public void init(){
    List<HandlerMethodArgumentResolver> argumentResolvers = requestMappingHandlerAdapter.getArgumentResolvers();
    List<HandlerMethodArgumentResolver> newArgumentResolvers=new ArrayList<>();
    newArgumentResolvers.add(new PropertiesHandlerMethodArgumentResolver());
    newArgumentResolvers.addAll(argumentResolvers);
    requestMappingHandlerAdapter.setArgumentResolvers(newArgumentResolvers);
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
