package com.example.auto;

import com.example.config.WebConfiguration3;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Import;

@Import(WebConfiguration3.class)
@ConditionalOnWebApplication
public class WebAutoConfiguration {
}
