package com.springboot.overview.web.servlet;


import java.io.IOException;
import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 异步非阻塞servlet
 */
@WebServlet(urlPatterns = "/my/async/servlet",asyncSupported = true)
public class asyncServlet extends HttpServlet {


  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
//    获取异步上下文
    AsyncContext asyncContext = req.startAsync();
    //在异步上下文中执行
    asyncContext.start(()->{
      try {
        resp.getWriter().println("hello,asyncServlet");
        //触发完成
        asyncContext.complete();
      } catch (IOException e) {
        e.printStackTrace();
      }
    });
  }
}
