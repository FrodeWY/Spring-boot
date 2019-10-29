package reflect;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;

public class Test1 {
//  从打印结果看来,具有<>符号的变量是参数化类型
  public static void main(String[] args) throws IllegalAccessException {
    Field[] fields = ParameterizedBean.class.getDeclaredFields();
    ParameterizedBean bean=new ParameterizedBean();
    for(Field f:fields){

      //是否是ParameterizedType
      System.out.println(f.getName()+":"+(f.getGenericType() instanceof ParameterizedType));
    }
    fields[0].setAccessible(true);
    fields[0].set(bean,new ArrayList<>());
    System.out.println(bean);
  }
}
