package com.imooc.web.spring.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
    urlPatterns = "/async-servlet",
    name = "asyncServlet", //servlet名字
    asyncSupported = true//激活异步特性
)
public class AsyncServlet extends HttpServlet {

  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
    HttpServletRequest request = (HttpServletRequest) req;
    //判断是否支持异步
    if (request.isAsyncSupported()) {
      //创建AsyncContext
      AsyncContext asyncContext = request.startAsync();
      //设置超时时间
      asyncContext.setTimeout(50L);
      asyncContext.addListener(new AsyncListener() {
        @Override
        public void onComplete(AsyncEvent event) throws IOException {
          println("执行完成");
        }

        @Override
        public void onTimeout(AsyncEvent event) throws IOException {
          HttpServletResponse response = (HttpServletResponse) event.getSuppliedResponse();
          response.setStatus(HttpServletResponse.SC_SERVICE_UNAVAILABLE);
          println("执行超时");
        }

        @Override
        public void onError(AsyncEvent event) throws IOException {
          println("执行出错");
        }

        @Override
        public void onStartAsync(AsyncEvent event) throws IOException {
          println("开始执行");
        }
      });
      println("开始执行hello");
     /* ServletResponse response = asyncContext.getResponse();
      //设置相应媒体类型
      response.setContentType("text/plain;charset=UTF-8");
      //获取字符输出流
      PrintWriter writer = response.getWriter();

      writer.write("Hello world");

      writer.flush();*/
    }


  }
  public static void println(Object object) {
    System.out.println("Thread name:" + Thread.currentThread().getName() + " say:" + object.toString());
  }

}
