package com.imooc.web.spring.servlet.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;


/**
 * HelloWord异步{@link RestController}
 */
@RestController
public class HelloWorldAsyncController {


  @GetMapping("/helloWorld")
  public DeferredResult<String > helloWorld(){
    DeferredResult<String> result = new DeferredResult<>();
    result.setResult("hello world");
    result.onCompletion(()->{
       System.out.println("HelloWorldAsyncController complete");
    });
    return result;
  }

}
