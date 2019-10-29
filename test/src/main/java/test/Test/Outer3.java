package test.Test;

public class Outer3 {
  public static IAnimal getInnerInstance(String speak){
    int a=10;
    return new IAnimal(){
      @Override
      public void speak(){
        System.out.println(speak);
        System.out.println(a);
      }};
    //注意上一行的分号必须有
  }
  public static Person getInnerInstance2(String speak){
    int a=10;
    return new Person() {
      @Override
      public void say2(){
        System.out.println("person2");
      }
    };
    //注意上一行的分号必须有
  }
  public static void main(String[] args){
    //调用的speak()是重写后的speak方法。
    Outer3.getInnerInstance("小狗汪汪汪！").speak();
  }

}
