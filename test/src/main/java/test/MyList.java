package test;

import java.util.ArrayList;

class MyList extends ArrayList<String> {
  /**
   * 子类重写父类的方法，返回值可以不一样
   * 但这里只能用数组类型，换成Object就不行
   * 应该算是java本身的bug
   */
  @Override
  public String[] toArray() {
    return new String[]{};
  }


  //  @Override
//  public String[] toArray() {
//    // 为了方便举例直接写死
//    return new String[]{"1", "2", "3"};
//  }
}
