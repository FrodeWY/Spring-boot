package springboot.autoconfigure.service;


import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("java7")//profile 条件装配--基于配置方式实现
public class Java7CalculateServiceImpl implements CalculateService {

  @Override
  public Integer sum(Integer... values) {
    Integer sum=0;
    System.out.println("java 7");
    for (Integer value : values) {
      sum+=value;
    }
    return sum;
  }
}
