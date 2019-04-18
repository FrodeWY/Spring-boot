package com.imooc.web.method.support;

import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Properties;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;

public class PropertiesHandlerMethodReturnValueHandler implements HandlerMethodReturnValueHandler {

  @Override
  public boolean supportsReturnType(MethodParameter returnType) {
    //判断方法的返回值类型是否于Properties匹配
    return Properties.class.equals(returnType.getMethod().getReturnType());
  }

  @Override
  public void handleReturnValue(Object returnValue, MethodParameter returnType,
      ModelAndViewContainer mavContainer, NativeWebRequest webRequest) throws Exception {
        Properties properties=(Properties)returnValue;
    ServletWebRequest servletWebRequest = (ServletWebRequest) webRequest;
    HttpServletRequest request = servletWebRequest.getRequest();
    String contentType = request.getHeader("Content-Type");
    MediaType mediaType=MediaType.parseMediaType(contentType);

    HttpServletResponse response = servletWebRequest.getResponse();
    ServletOutputStream outputStream = response.getOutputStream();

    Charset charset = mediaType.getCharset()==null?Charset.defaultCharset():mediaType.getCharset();
    OutputStreamWriter writer=new OutputStreamWriter(outputStream, charset);
    properties.store(writer,"From PropertiesHandlerMethodReturnValueHandler");
    mavContainer.setRequestHandled(true);
  }
}
