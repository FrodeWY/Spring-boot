package com.imooc.spring.reactive.load;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 并行数据加载
 * 结论：明显地，程序改造为并行加载后，性能和资源利用率得到提升，消耗时间取最大者
 */
public class ParallelDataLoader extends DataLoader {

  @Override
  protected void doLoad() {
    ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
    CompletionService completionService = new ExecutorCompletionService(fixedThreadPool);
    completionService.submit(super::loadConfigurations, null);
    completionService.submit(super::loadUsers, null);
    completionService.submit(super::loadOrders, null);
    int count = 0;
    while (count < 3) {
      if (completionService.poll() != null) {
        count++;
      }
    }
    fixedThreadPool.shutdown();
  }

  public static void main(String[] args) {
    new ParallelDataLoader().load();
  }
}
