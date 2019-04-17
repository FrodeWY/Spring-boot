package springboot.autoconfigure.configuration;


import org.springframework.context.annotation.Configuration;
import springboot.autoconfigure.annotation.EnableHelloWorld;
import springboot.autoconfigure.condition.ConditionalOnSystemProperty;

/**
 * 在META-INF 下的spring.factories中，以org.springframework.boot.autoconfigure.EnableAutoConfiguration为key的当前类路径为value，
 * 加入自动装配，启动类需要开启@EnableAutoConfiguration
 *
 *流程：
 * 条件判断：user.name == "Mercy"
 * 模式注解：@Configuration
 * @Enable模块：@EnableHelloWorld -> HelloWorldImportSelector ->  HelloWorldConfiguration - > helloWorld
 */
@Configuration//模式装配
@ConditionalOnSystemProperty(name = "user.name",value = "wangyang")//条件装配
@EnableHelloWorld//@Enable 模块装配
public class HelloWorldAutoConfiguration {

}
