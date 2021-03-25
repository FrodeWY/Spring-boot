package com.example.bootstrap.example7;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
//@Import(EnableServerSelector.class)
@Import(EnableServerImportBeanDefinitionRegistrar.class)
public @interface EnableServer {
    ServerTypeEnum type();
}
