package com.imooc.web.reactive.controller;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import com.imooc.web.reactive.bootstrap.WebFluxApplication;
import com.imooc.web.reactive.util.PrintlnUtil;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Configuration
public class FunctionalEndpointsController {

  @Bean
  public RouterFunction<ServerResponse> routerFunction() {
    FunctionalEndpointsController handler = new FunctionalEndpointsController();
  /*  return RouterFunctions.route(request -> {//判断请求是否匹配
      URI uri = request.uri();
      return "/hello-world".equals(uri.getPath());
    },request -> {//绑定实现
      return ServerResponse.status(HttpStatus.OK)
          .body(Mono.just("hello-world"),String.class);
    });*/

    return route(GET("/hello-world").and(accept(MediaType.APPLICATION_JSON_UTF8)), handler::helloWorld)
        .andRoute(GET("/hello-world2").and(accept(MediaType.APPLICATION_JSON_UTF8)), handler::helloWorld2);
  }


  public Mono<ServerResponse> helloWorld(ServerRequest serverRequest) {
    Optional<String> id = serverRequest.queryParam("id");
    id.ifPresent(s -> System.out.println("id:" + s));
    PrintlnUtil.println("helloWorld");
    return ServerResponse.status(HttpStatus.OK).body(Mono.just("hello"), String.class);
  }

  public Mono<ServerResponse> helloWorld2(ServerRequest serverRequest) {
    PrintlnUtil.println("helloWorld2");
    return ServerResponse.status(HttpStatus.OK).body(Mono.just("hello2"), String.class);
  }
}
