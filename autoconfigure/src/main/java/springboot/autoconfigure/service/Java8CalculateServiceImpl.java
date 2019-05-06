package springboot.autoconfigure.service;


import java.util.stream.Stream;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("java8")//profile 条件装配，spring3.1之后启用--基于配置方式实现
public class Java8CalculateServiceImpl implements CalculateService {

  @Override
  public Integer sum(Integer... values) {
    System.out.println("java8");
    //java8 流式处理

    return Stream.of(values).reduce(0, Integer::sum);
  }
}
