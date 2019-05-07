package com.imooc.spring.reactive.test;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public class CompletableFutureTest {


  public static void main(String[] args) {
    CompletableFuture.supplyAsync(() -> {
      return 2;
    }).thenApply((i) -> {
      return 2 * i;
    }).thenApply((i) -> {
      return "result:" + i;
    }).whenComplete((result, throwable) -> {
      if (throwable == null) {
        System.out.println(result);
      } else {
        System.out.println(throwable.getMessage());
      }
    }).join();
  }


}
