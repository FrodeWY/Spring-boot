package test.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 定义动态代理类
 * 1.JDK的动态代理必须基于接口，CGLIB没有这个要求,JDK动态代理只能对实现了接口的类生成代理，而不能针对类
 * 2.CGLIB是针对类实现代理，主要是对指定的类生成一个子类，覆盖其中的方法因为是继承，所以该类或方法不要声明成final
 * 3. java动态代理是利用反射机制生成一个实现代理接口的匿名类，在调用具体方法前调用InvokeHandler来处理。
 * 而cglib动态代理是利用asm开源包，将代理对象类的class文件加载进来，通过修改其字节码生成子类来处理。
 */
public class PersonProxy implements InvocationHandler {
  //业务实现类对象，用来调用具体的业务方法
  private Object target;
  /**
   * 绑定业务对象并返回一个代理类
   */
  public Object bind(Object target) {
    this.target = target;
    //创建代理对象时，需要传递该业务类的类加载器（用来获取业务实现类的元数据，在包装方法是调用真正的业务方法）、接口、handler实现类
    return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    System.out.println("JDK person 动态代理开始");
    //调用真正的业务方法
    Object result = method.invoke(target, args);
    System.out.println("JDK person 动态代理结束");
    return result;
  }
}
