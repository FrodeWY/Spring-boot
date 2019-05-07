package com.imooc.spring.reactive.load;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * {@link Future }阻塞数据加载器
 * 结论:Future#get() 方法不得不等待任务执行完成，换言之，如果多个任务提交后，返回的多个 Future
 * 逐一调用 get() 方法时，将会依次 blocking，任务的执行从并行变为串行
 */
public class FutureBlockingDataLoader extends DataLoader{
  protected void doLoad() {
    ExecutorService executorService = Executors.newFixedThreadPool(3); // 创建线程池
    runCompletely(executorService.submit(super::loadConfigurations));
    runCompletely(executorService.submit(super::loadUsers));
    runCompletely(executorService.submit(super::loadOrders));
    executorService.shutdown();
    System.out.println("completion");
  }
  private void runCompletely(Future<?> future) {
    try {
      future.get();
    } catch (Exception e) {
    }
  }
  public static void main(String[] args) {
    new FutureBlockingDataLoader().load();
  }
}
