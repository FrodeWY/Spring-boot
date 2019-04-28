package com.imooc.web.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldRestController {


  @GetMapping("hello")
//  @CrossOrigin("*")
  public String hello(@RequestParam(required = false) String message) {
    return "hello :" + message;
  }
}
