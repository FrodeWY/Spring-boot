package com.example.bootstrap.example7;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(EnableHelloWorldSelector.class)
public @interface EnableHelloWorld {

    String condition() default "";
}
