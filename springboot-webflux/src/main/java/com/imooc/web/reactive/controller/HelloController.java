package com.imooc.web.reactive.controller;

import com.imooc.web.reactive.util.PrintlnUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class HelloController {

  @GetMapping("/mvc")
  public String mvc() {
    PrintlnUtil.println("mvc");
    return "mvc";
  }

  @GetMapping("/mono")
  public Mono<String> mono() {
    PrintlnUtil.println("mono");
    return Mono.just("mono");
  }
}
