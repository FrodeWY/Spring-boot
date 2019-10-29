package test.Test;

public class Test3 extends Father {
  public static int i=0;     // 3
  public int j=0;     // 8

  public Test3(){     // 10
    System.out.println("Test Constructor");
  }

  {     // 9
    System.out.println("Test not static block");
  }

  static {     // 4
    System.out.println("Test static block");
  }

  public static void main(String[] args) throws Exception {
    new Test3();
  }

}
class Father{
  static {     // 1
    System.out.println("Father static block");
  }

  {     // 5
    System.out.println("Father not static block");
  }

  public Father(){     // 7
    System.out.println("Father Constructor");
  }

  public static int i=0;     // 2
  public int j=0;     // 6
}
