package test.Test2;

public class Person implements Cloneable{
  private String name;
  private Home home;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Home getHome() {
    return home;
  }

  public void setHome(Home home) {
    this.home = home;
  }

  public Object  clone(){
    try {
      Person clone = (Person)super.clone();
      clone.home=(Home) home.clone();
      return clone;
    } catch (CloneNotSupportedException e) {
      e.printStackTrace();
    }
    return null;
  }

  public static void main(String[] args) {
    Person person=new Person();
    person.name="lili";
    Home home = new Home();
    home.setAddr("beijing");
    person.setHome(home);
    Person clone = (Person) person.clone();
    System.out.println(person.home.getAddr());
    clone.getHome().setAddr("nanjing");
    System.out.println(person.home.getAddr());
  }
}
