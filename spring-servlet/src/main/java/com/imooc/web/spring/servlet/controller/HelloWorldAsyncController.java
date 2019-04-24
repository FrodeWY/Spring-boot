package com.imooc.web.spring.servlet.controller;


import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;


/**
 * HelloWord异步{@link RestController}
 */
@RestController
@EnableScheduling
public class HelloWorldAsyncController {


  private final BlockingQueue<DeferredResult<String>> queue = new ArrayBlockingQueue<>(5);
  //超时随机数
  private final Random random = new Random();

  @Scheduled(fixedDelay = 5000)
  public void process() throws InterruptedException {
    DeferredResult<String> result = null;
    do {
      result = queue.take();
      //随机超时时间
      int timeout = random.nextInt(100);
      //模拟等待时间,RPC或者DB查询
      Thread.sleep(timeout);
      println("执行计算结果,耗时:" + timeout);
      //计算结果输出
      result.setResult("Hello world");
    } while (result != null);
  }

  @GetMapping("/completion-stage")
  public CompletionStage<String> completionStage() {
    final long startTime = System.currentTimeMillis();
    println("completion-stage-hello-World");

    return CompletableFuture.supplyAsync(() -> {
      long costTime = System.currentTimeMillis() - startTime;
      println("执行计算消耗:" + costTime + " ms");
      return "completion-stage-hello-World-result";
    });
  }

  @GetMapping("/callable-hello-World")
  public Callable<String> callableHelloWorld() {
    final long startTime = System.currentTimeMillis();
    println("callable-hello-World");

    return () -> {
      long costTime = System.currentTimeMillis() - startTime;
      println("执行计算消耗:" + costTime + " ms");
      return "callable-hello-World-result";
    };
  }


  @GetMapping("/helloWorld")
  public DeferredResult<String> helloWorld() {
    DeferredResult<String> result = new DeferredResult<>(50L);
//    result.setResult("hello world");
//入队操作
    queue.offer(result);
    println("hello world");
    result.onCompletion(() -> {//onCompletion 类似于final代码块,总是会执行
//      System.out.println("HelloWorldAsyncController complete");
      println("HelloWorldAsyncController complete");
    });
    result.onTimeout(() -> {//timeout 时会发生线程切换
      println("HelloWorldAsyncController timeout");
    });
    return result;
  }

  public static void println(Object object) {
    System.out.println("Thread name:" + Thread.currentThread().getName() + " say:" + object.toString());
  }
}
