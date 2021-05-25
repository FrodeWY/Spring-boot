package springboot;

import org.springframework.context.support.GenericApplicationContext;

public class ApplicationListenerBootstrap {
    public static void main(String[] args) {
        final GenericApplicationContext context = new GenericApplicationContext();
        context.addApplicationListener(event -> System.out.println("触发事件:  "+event.getClass().getSimpleName()));
        context.refresh();
        context.stop();
        context.start();
        context.close();
    }


}
