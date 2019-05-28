package test.proxy.jdk;

/**
 * 实现类
 */
public class Man implements Person {

  @Override
  public String doSomething() {
    System.out.println("男人做事");
    return "男人做事";
  }

  @Override
  public void say() {
    System.out.println("男人说话");
  }
}
