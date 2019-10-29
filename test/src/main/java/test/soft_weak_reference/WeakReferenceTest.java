package test.soft_weak_reference;

import java.lang.ref.WeakReference;
import java.math.BigDecimal;

/**
 * 弱引用也是用来描述非必需对象的，当JVM进行垃圾回收时，无论内存是否充足，都会回收被弱引用关联的对象。
 * 在java中，用java.lang.ref.WeakReference类来表示。
 * 第二个o:输出结果是null，这说明只要JVM进行垃圾回收，被弱引用关联的对象必定会被回收掉。不过要注意的是，
 * 这里所说的被弱引用关联的对象是指只有弱引用与之关联，如果存在强引用同时与之关联，则进行垃圾回收时也不会回收该对象（软引用也是如此）如第二个o1输出就不为null。
 */
public class WeakReferenceTest {

  public static void main(String[] args) throws InterruptedException {

    WeakReference<String> o = new WeakReference<>(new String("hello"));
    String s = new String("hello s");
    WeakReference<String> o1 = new WeakReference<>(s);
    System.out.println("o:"+o.get());
    System.out.println("o1:"+o1.get());
    s=null;//当没有强引用与之关联，垃圾回收时会回收被弱引用关联的对象
    System.gc();
    Thread.sleep(5000);
    System.out.println("o:"+o.get());
    System.out.println("o1:"+o1.get());



  }

}
