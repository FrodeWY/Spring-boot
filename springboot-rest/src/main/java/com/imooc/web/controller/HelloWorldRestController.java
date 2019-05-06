package com.imooc.web.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldRestController {


  @GetMapping("hello")
//  @CrossOrigin("*")//设置允许跨域,如果不设置跨域,则后台能收到请求,浏览器会拦截结果
  public String hello(@RequestParam(required = false) String message) {
    return "hello :" + message;
  }
}
