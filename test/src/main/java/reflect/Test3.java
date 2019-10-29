package reflect;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;

public class Test3 {

  public static void main(String[] args) {
    Field[] fields =  ParameterizedBean.class.getDeclaredFields();
    for(Field f:fields){
      if(f.getGenericType() instanceof ParameterizedType){
        ParameterizedType pType = (ParameterizedType) f.getGenericType();
        System.out.print("变量："+f.getName()+" ");
        //pType.getRawType()变量的类型
        System.out.println("RawType："+pType.getRawType().getTypeName());
      }
    }
  }


}
