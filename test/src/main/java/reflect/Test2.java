package reflect;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class Test2 {

  public static void main(String[] args) {
    Field[] fields = ParameterizedBean.class.getDeclaredFields();
    for (Field f : fields) {
      if (f.getGenericType() instanceof ParameterizedType) {
        ParameterizedType pType = (ParameterizedType) f.getGenericType();
        System.out.println("变量：" + pType.getTypeName() + "     ");
        //getActualTypeArguments()返回了一个Type数组,数组里是参数化类型的参数
        Type[] types = pType.getActualTypeArguments();
        for (Type t : types) {
          if (t.getTypeName().equals(String.class.getTypeName())) {
            System.out.println("equal string");
          }
          System.out.println("类型：" + t.getTypeName());
        }
      }
    }
  }
}
