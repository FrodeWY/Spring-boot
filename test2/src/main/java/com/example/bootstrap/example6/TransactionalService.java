package com.example.bootstrap.example6;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Transactional
@Service(value = "test")
public @interface TransactionalService {
/*
    @AliasFor(annotation = Service.class, attribute = "value")
    String name() default "";
*/

    @AliasFor(annotation = Transactional.class, attribute = "transactionManager")
    String manager() default "txManager";

    String value() default "";

}
