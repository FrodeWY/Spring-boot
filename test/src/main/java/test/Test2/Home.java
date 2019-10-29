package test.Test2;

public class Home implements Cloneable{
  private String addr;

  public String getAddr() {
    return addr;
  }

  public void setAddr(String addr) {
    this.addr = addr;
  }
  public Object  clone(){
    try {
      return  super.clone();
    } catch (CloneNotSupportedException e) {
      e.printStackTrace();
    }
    return null;
  }
}
