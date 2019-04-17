package springboot.autoconfigure.repository;


import springboot.autoconfigure.annotation.FirstLevelRepository;
import springboot.autoconfigure.annotation.SecondLevelRepository;

/**
 * 我的{@link FirstLevelRepository}
 */
@SecondLevelRepository(value = "mySecondLevelRepository")//Bean 名称
public class MySecondLevelRepository {

}
