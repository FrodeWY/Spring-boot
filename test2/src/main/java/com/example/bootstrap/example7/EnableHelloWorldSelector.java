package com.example.bootstrap.example7;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class EnableHelloWorldSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        Set<String> annotationTypes = importingClassMetadata.getAnnotationTypes();
        System.out.println("annotationTypes:" + annotationTypes);
        Map<String, Object> annotationAttributes = importingClassMetadata.getAnnotationAttributes(EnableHelloWorld.class.getName());
        if (Objects.requireNonNull(annotationAttributes).containsKey("condition")) {
            String condition = (String) annotationAttributes.get("condition");
            if ("helloWorld".equals(condition)) {
                return new String[]{HelloWorldConfiguration.class.getName()};
            }
        }
        return new String[0];
    }

}
