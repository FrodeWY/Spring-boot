package com.imooc.spring.reactive.load;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * 链式数据加载器
 *
 * 由于 Future 无法实现异步执行结果链式处理，尽管 FutureBlockingDataLoader 能够解决方法数据依赖 以及顺序执行的问题，不过它将并行执行带回了阻塞（串行）执行。所以，它不是一个理想实现。不过 CompletableFuture 可以帮助提升 Future 的限制：
 */
public class ChainDataLoader extends DataLoader {

  protected void doLoad() {
    //异步非阻塞
    CompletableFuture<Void> completableFuture = CompletableFuture
        .runAsync(super::loadConfigurations)
        .thenRun(super::loadUsers)
        .thenRun(super::loadOrders)
        .whenComplete((result, throwable) -> { // 完成时回调
          System.out.println("[线程 : " + Thread.currentThread().getName() + "]加载完成");
        })
        .exceptionally(throwable -> {//异常时回调
              System.out.println("[线程 : " + Thread.currentThread().getName() + "]加载异常");
              return null;
            }
        );

    System.out.println("111");
    completableFuture.join(); // 等待完成
    System.out.println("222");

  }

  public static void main(String[] args) {
    new ChainDataLoader().load();
  }
}
