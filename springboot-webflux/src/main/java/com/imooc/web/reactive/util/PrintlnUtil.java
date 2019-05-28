package com.imooc.web.reactive.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PrintlnUtil {

  public static void println(String message) {
    System.out.println("[" + Thread.currentThread().getName() + "] : " + message);
  }

  public static void main(String[] args) {
    String pattern = "[\\$\\\\\\(\\)\\*\\+\\.\\[\\?\\^\\{\\|\\<\\>]";
    // 创建 Pattern 对象
    Pattern reg = Pattern.compile(pattern);
    Matcher matcher = reg.matcher("?");
    if (matcher.find()) {
      System.out.println("find");
    } else {
      System.out.println("end");
    }
  }
}
