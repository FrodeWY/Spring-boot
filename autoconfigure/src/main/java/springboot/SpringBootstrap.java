package springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

@SpringBootApplication
public class SpringBootstrap implements ApplicationEventPublisherAware {
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;


    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        System.out.println("applicationEventPublisher:"+(this.applicationEventPublisher == applicationEventPublisher));
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootstrap.class);
    }
}
