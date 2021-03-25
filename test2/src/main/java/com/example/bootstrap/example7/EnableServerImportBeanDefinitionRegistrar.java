package com.example.bootstrap.example7;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Stream;

public class EnableServerImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        Map<String, Object> annotationAttributes = importingClassMetadata.getAnnotationAttributes(EnableServer.class.getName());
        ServerTypeEnum type = (ServerTypeEnum) annotationAttributes.get("type");
        String[] importClasses = new String[0];
        switch (type) {
            case HTTP:
                importClasses = new String[]{HttpServer.class.getName()};
                break;
            case FTP:
                importClasses = new String[]{FtpServer.class.getName()};
                break;
        }
        Stream.of(importClasses).map(BeanDefinitionBuilder::genericBeanDefinition).map(BeanDefinitionBuilder::getBeanDefinition).forEach(beanDefinition -> {
            BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinition, registry);
        });

    }
}
