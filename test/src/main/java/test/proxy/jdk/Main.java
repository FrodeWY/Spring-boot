package test.proxy.jdk;

/**
 * jdk动态代理测试
 */
public class Main {

  public static void main(String[] args) {
    Man man = new Man();
    PersonProxy personProxy = new PersonProxy();
    Person person = (Person) personProxy.bind(man);
    String something = person.doSomething();
    System.out.println("结果:" + something);
    person.say();
  }

}
