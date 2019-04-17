package springboot.autoconfigure.repository;


import springboot.autoconfigure.annotation.FirstLevelRepository;

/**
 * 我的{@link FirstLevelRepository}
 */
@FirstLevelRepository(value = "myFirstLevelRepository")//Bean 名称
public class MyFirstLevelRepository {

}
