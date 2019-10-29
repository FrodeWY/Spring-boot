package test.soft_weak_reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class PhantomReferenceTest {

  public static void main(String[] args) {
    ReferenceQueue<String> queue = new ReferenceQueue<String>();
    PhantomReference<String> pr = new PhantomReference<String>(new String("hello"), queue);
    System.out.println(pr.get());
  }
}
