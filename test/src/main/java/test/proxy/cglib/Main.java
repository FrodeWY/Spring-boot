package test.proxy.cglib;

public class Main {

  public static void main(String[] args) {
    BookFacadeImpl bookFacade=new BookFacadeImpl();
    CglibProxy cglibProxy = new CglibProxy();
    BookFacadeImpl bookFacadeImplProxy = (BookFacadeImpl) cglibProxy.bind(bookFacade);
    bookFacadeImplProxy.addBook();
  }
}
