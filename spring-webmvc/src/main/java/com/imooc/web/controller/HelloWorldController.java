package com.imooc.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

  @RequestMapping("")
  public String index(@RequestParam int number, Model model){
//    model.addAttribute("message", "hello world");
//    model.addAttribute("language",acceptLanguage);
//    model.addAttribute("jsessionId",jsessionId);
    return "index";
  }

}
