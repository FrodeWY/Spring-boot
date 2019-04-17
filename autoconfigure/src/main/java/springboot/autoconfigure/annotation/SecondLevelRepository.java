package springboot.autoconfigure.annotation;


import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 二级{@link FirstLevelRepository @FirstLevelRepository}
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@FirstLevelRepository
public @interface SecondLevelRepository {
    String value() default "";
}
