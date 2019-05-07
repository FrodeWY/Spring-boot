package com.imooc.spring.reactive.load;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * {@link Future }阻塞数据加载器
 */
public class FutureUnBlockingDataLoader extends DataLoader{
  protected void doLoad() {
    ExecutorService executorService = Executors.newFixedThreadPool(3); // 创建线程池
    List<Future> futureList=new ArrayList<>();
    futureList.add(executorService.submit(super::loadConfigurations));
    futureList.add(executorService.submit(super::loadUsers));
    futureList.add(executorService.submit(super::loadOrders));
    for (Future future : futureList) {
      try {
        future.get();
      } catch (InterruptedException | ExecutionException e) {
      }

    }
    executorService.shutdown();
  }
  private void runCompletely(Future<?> future) {
    try {
      future.get();
    } catch (Exception e) {
    }
  }
  public static void main(String[] args) {
    new FutureUnBlockingDataLoader().load();
  }
}
