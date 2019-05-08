package com.imooc.web.reactive.util;

public class PrintlnUtil {
  public static void println(String message) {
    System.out.println("[" + Thread.currentThread().getName() + "] : " + message);
  }
}
