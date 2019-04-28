package com.imooc.web.method.support;

import com.imooc.web.http.converter.properties.PropertiesHttpMessageConverter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Properties;
import javax.servlet.http.HttpServletRequest;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class PropertiesHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

  @Override
  public boolean supportsParameter(MethodParameter parameter) {
    return Properties.class.equals(parameter.getParameterType());
  }

  @Override
  public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory)
      throws Exception {
    ServletWebRequest servletWebRequest = (ServletWebRequest) webRequest;
    HttpServletRequest request = servletWebRequest.getRequest();
    // 复用 PropertiesHttpMessageConverter
    PropertiesHttpMessageConverter converter = new PropertiesHttpMessageConverter();
//    String contentType = request.getHeader("Content-Type");
//    MediaType mediaType = MediaType.parseMediaType(contentType);
//    Charset charset = mediaType.getCharset() == null ? Charset.forName("UTF-8") : mediaType.getCharset();
//    InputStream inputStream = request.getInputStream();
//    InputStreamReader reader = new InputStreamReader(inputStream, charset);
//    Properties properties = new Properties();
//    properties.load(reader);
    HttpInputMessage httpInputMessage = new ServletServerHttpRequest(request);
    return converter.read(null, null, httpInputMessage);
  }
}
