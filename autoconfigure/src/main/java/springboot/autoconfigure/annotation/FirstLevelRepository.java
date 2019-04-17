package springboot.autoconfigure.annotation;


import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.stereotype.Repository;

/**
 * 一级{@link Repository @Repository}
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Repository
public @interface FirstLevelRepository {
    //签名保持一致，派生性
    String value() default "";
}
