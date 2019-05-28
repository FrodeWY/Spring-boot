package test.proxy.cglib;

import java.lang.reflect.Method;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * cglib是针对类来实现代理的，原理是对指定的业务类生成一个子类，并覆盖其中业务方法实现代理。
 * 因为采用的是继承，所以不能对final修饰的类进行代理。
 */
public class CglibProxy implements MethodInterceptor {
  //业务类对象，供代理方法中进行真正的业务方法调用
  private Object target;
  //相当于JDK动态代理中的绑定
  public Object bind(Object target) {
    this.target = target;  //给业务对象赋值
    Enhancer enhancer = new Enhancer();//创建加强器，用来创建动态代理类
    enhancer.setSuperclass(this.target.getClass()); //为加强器指定要代理的业务类（即：为下面生成的代理类指定父类）
    //设置回调：对于代理类上所有方法的调用，都会调用CallBack，而Callback则需要实现intercept()方法进行拦截
    enhancer.setCallback(this);
    return enhancer.create();
  }

  @Override
  public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
    System.out.println("预处理----------");
    Object result = methodProxy.invoke(target, args);
    System.out.println("调用后操作---------------");
    return result;
  }
}
