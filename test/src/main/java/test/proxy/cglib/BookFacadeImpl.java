package test.proxy.cglib;

/**
 *  1：首先定义业务类，无需实现接口（当然，实现接口也可以，不影响的） 1：首先定义业务类，无需实现接口（当然，实现接口也可以，不影响的）
 */
public class BookFacadeImpl {
  public void addBook() {
    System.out.println("新增图书...");
  }
}
