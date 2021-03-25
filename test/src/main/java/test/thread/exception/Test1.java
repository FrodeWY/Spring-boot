package test.thread.exception;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test1 {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 2, 30, TimeUnit.SECONDS, new ArrayBlockingQueue<>(5));
        for (int i = 0; i < 8; i++) {
//            try {
//                Future<?> submit = threadPoolExecutor.submit(() -> sayHi("submit"));
//                submit.get();
            Future<?> submit = threadPoolExecutor.submit(() -> sayHi("submit"));
/*            } catch (Exception e) {
                //需要捕捉异常,否则shutdown()无法执行,线程池无法关闭,因为线程池抛出RejectedExecutionException,主线程已经结束,所以没有调用threadPoolExecutor.shutdown函数
                e.printStackTrace();
            }*/
        }

        threadPoolExecutor.shutdown();
    }

    private static void sayHi(String name) {
        String str = "[Thread-name :" + Thread.currentThread().getName() + "  ,执行方式:" + name + "]";
        System.out.println(str);
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        throw new RuntimeException(str+",我异常了");
    }


}
