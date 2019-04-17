package com.imooc.web.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice(assignableTypes = HelloWorldController.class)
public class HelloWorldAdvice {
  //model 的执行优先于handler
  @ModelAttribute("message")
  public String message(){
    return "hello world";
  }

//  @ModelAttribute("jsessionId")
//  public String jsessionId(@CookieValue(name = "JSESSIONID") String jsessionId){
//    return jsessionId;
//  }

  @ModelAttribute("language")
  public String language(@RequestHeader(name = "Accept-Language") String acceptLanguage){
    return acceptLanguage;
  }

  @InitBinder
   public void globalInitBinder(WebDataBinder binder ){
    System.out.println("globalInitBinder");
  }

  @ExceptionHandler(Throwable.class)
  public ResponseEntity<String > handlerException(Throwable throwable){
    return ResponseEntity.ok(throwable.getMessage());
  }
}
