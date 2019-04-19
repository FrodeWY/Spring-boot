package com.imooc.web.http.converter.properties;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Properties;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractGenericHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

/**
 * {@link Properties} {@link HttpMessageConverter} 解析properties的HttpMessageConverter
 */
public class PropertiesHttpMessageConverter extends AbstractGenericHttpMessageConverter<Properties> {

  public PropertiesHttpMessageConverter() {
    //设置支持的媒体类型
    super(new MediaType("text", "properties"));
  }

  @Override
  protected void writeInternal(Properties properties, Type type, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
    OutputStream outputStream = outputMessage.getBody();
    HttpHeaders headers = outputMessage.getHeaders();
    MediaType contentType = headers.getContentType();
    Charset charset = contentType.getCharset() == null ? Charset.forName("UTF-8") : contentType.getCharset();
    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, charset);
    properties.store(outputStreamWriter, "From PropertiesHttpMessageConverter");
  }

  @Override
  protected Properties readInternal(Class clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
    InputStream inputStream = inputMessage.getBody();
    HttpHeaders headers = inputMessage.getHeaders();
    //从contentType中解析charset,作为字符流的编码
    MediaType contentType = headers.getContentType();
    Charset charset = contentType.getCharset() == null ? Charset.forName("UTF-8") : contentType.getCharset();
    InputStreamReader reader = new InputStreamReader(inputStream, charset);
    //加载字符流成为Properties
    Properties properties = new Properties();
    properties.load(reader);
    return properties;
  }

  @Override
  public Properties read(Type type, Class contextClass, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
    return readInternal(null, inputMessage);
  }
}
