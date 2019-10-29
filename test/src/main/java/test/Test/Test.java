package test.Test;

import test.User;

public class Test {
  static int age=1;
  String name ="dd";

  public static void main(String[] args) {
    User user=new User();
    user.setName("lili");
    change(user);
    System.out.println(user);
  }

  public static void change(User user){
    user=null;
  }
  public void test(){

  }
}
