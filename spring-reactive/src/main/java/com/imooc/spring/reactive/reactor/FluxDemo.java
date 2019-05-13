package com.imooc.spring.reactive.reactor;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class FluxDemo {


  public static void main(String[] args) {
    println("运行开始");
    Flux.just("A", "B", "C", "D")//发布A->B->C->D
//        .publishOn(Schedulers.elastic())//线程池切换,将数据交由Reactor 调度线程池,异步执行
        .map(element -> "+" + element)//"A"->"+"转换
//        .subscribe(
//            FluxDemo::println,//数据消费=onNext(T t);
//            FluxDemo::println,//异常处理=onError(Throwable t);
//            () -> println("完成操作!"),//完成回调,由Reactor 调度线程池,异步执行的情况下由于主线程先结束,这里的回调可能并不执行=onComplete();
//            subscription -> {//背压操作=onSubscribe(Subscription s);
//              subscription.request(3); //n 请求的元素数量
//              subscription.cancel(); //取消上游传输数据到下游
//            }
//        )
    .subscribe(new Subscriber<String>() {
      private Subscription subscription;
      private int count;
      @Override
      public void onSubscribe(Subscription s) {
        subscription=s;
        subscription.request(1);
      }

      @Override
      public void onNext(String s) {
        if(count==2){
          throw new RuntimeException("故意抛异常");
        }
        count++;
        println(s);
        subscription.request(1);
      }

      @Override
      public void onError(Throwable throwable) {
        println(throwable.getMessage());
      }

      @Override
      public void onComplete() {
        println("完成操作!");
      }
    });
    println("运行结束");
  }

  public static void println(Object o) {
    System.out.println("[线程:" + Thread.currentThread().getName() + "] " + o);
  }
}
