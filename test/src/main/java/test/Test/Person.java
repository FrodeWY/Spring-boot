package test.Test;

public class Person {

  public static void say(){
    System.out.println("person");
  }
  public  void say2(){
    System.out.println("person");
  }
  public static void main(String[] args) {
    Person person = new Person();
    person.say();
  }
}
