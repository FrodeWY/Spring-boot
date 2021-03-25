package com.example.bootstrap.example6;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.StandardAnnotationMetadata;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.MultiValueMap;
import org.springframework.util.ObjectUtils;
import org.springframework.util.ReflectionUtils;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.annotation.Target;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@TransactionalService(value = "start")
@ComponentScan(basePackages = "com.example.bootstrap.example6")
@Configuration
@Service(value = "twe")
public class TransactionalServiceBootstrap {
    public static void main(String[] args) throws IOException {
        test1();
    }

    private static void test1() throws IOException {
        String className = TransactionalServiceBootstrap.class.getName();
        MetadataReaderFactory metadataReaderFactory = new CachingMetadataReaderFactory();
        MetadataReader metadataReader = metadataReaderFactory.getMetadataReader(className);
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        Set<String> annotationTypes = annotationMetadata.getAnnotationTypes();
        for (String annotationType : annotationTypes) {
            Set<String> metadataMetaAnnotationTypes = annotationMetadata.getMetaAnnotationTypes(annotationType);
            Map<String, Object> annotationAttributes = annotationMetadata.getAnnotationAttributes(annotationType);
            MultiValueMap<String, Object> allAnnotationAttributes = annotationMetadata.getAllAnnotationAttributes(annotationType);
            System.out.printf("注解:%s 属性:%s \n", annotationType, annotationAttributes);
            for (String metadataMetaAnnotationType : metadataMetaAnnotationTypes) {
                System.out.printf("注解:%s  元注解:%s\n", annotationType, metadataMetaAnnotationType);
            }
        }
    }

    public static void test2() {
        AnnotatedElement annotatedElement = TransactionalServiceBootstrap.class;
        TransactionalService annotation = annotatedElement.getAnnotation(TransactionalService.class);
//        String valueAttribute = annotation.name();
//        System.out.printf("reflect TransactionalService value:%s", valueAttribute);
    }

    public static void test3() {
        AnnotatedElement annotatedElement = TransactionalServiceBootstrap.class;
        TransactionalService annotation = annotatedElement.getAnnotation(TransactionalService.class);
        ReflectionUtils.doWithMethods(TransactionalService.class, method -> System.out.printf("TransactionalService.%s()=%s\n", method.getName(), ReflectionUtils.invokeMethod(method, annotation)), method -> method.getParameterCount() == 0);
        //所有注解都继承了Annotation接口,排除Annotation接口里的方法
        ReflectionUtils.doWithMethods(TransactionalService.class, method -> System.out.printf("TransactionalService.%s()=%s\n", method.getName(), ReflectionUtils.invokeMethod(method, annotation)), method -> !method.getDeclaringClass().equals(Annotation.class));
    }

    public static void test4() {
        Class<TransactionalServiceBootstrap> aClass = TransactionalServiceBootstrap.class;
        for (Method declaredMethod : aClass.getDeclaredMethods()) {
            System.out.printf("method:%s,modifies:%s\n", declaredMethod.getName(), declaredMethod.getModifiers());
        }
    }

    public static void test5() {
        AnnotatedElement element = TransactionalServiceBootstrap.class;
        TransactionalService annotation = element.getAnnotation(TransactionalService.class);
        Set<Annotation> allMetaAnnotation = getAllMetaAnnotation(annotation);
        allMetaAnnotation.forEach(TransactionalServiceBootstrap::print);
    }

    private static Set<Annotation> getAllMetaAnnotation(Annotation annotation) {
        Annotation[] annotations = annotation.annotationType().getAnnotations();
        if (ObjectUtils.isEmpty(annotations)) {
            return Collections.emptySet();
        }
        Set<Annotation> annotationSet = Stream.of(annotations).filter(metaAnnotation -> !Target.class.getPackage().equals(metaAnnotation.annotationType().getPackage())).collect(Collectors.toSet());
        HashSet<Annotation> metaMetaAnnotationsSet = annotationSet.stream().map(TransactionalServiceBootstrap::getAllMetaAnnotation).collect(HashSet::new, Set::addAll, Set::addAll);
        annotationSet.addAll(metaMetaAnnotationsSet);
        return annotationSet;
    }

    private static void print(Annotation annotation) {
        Class<? extends Annotation> annotationType = annotation.annotationType();
        ReflectionUtils.doWithMethods(annotationType, method ->
                        System.out.printf("@%s.%s() = %s\n", annotationType.getSimpleName(), method.getName(), ReflectionUtils.invokeMethod(method, annotation)),
                method -> method.getParameterCount() == 0 && !method.getDeclaringClass().equals(Annotation.class));
    }

    public static void test6() {
        AnnotationMetadata annotationMetadata = new StandardAnnotationMetadata(TransactionalServiceBootstrap.class);
        LinkedHashSet<String> allAnnotationMetadata = annotationMetadata.getAnnotationTypes().stream().map(annotationMetadata::getMetaAnnotationTypes).collect(LinkedHashSet::new, Set::addAll, Set::addAll);
        allAnnotationMetadata.forEach(metaAnnotation -> {
            Map<String, Object> annotationAttributes = annotationMetadata.getAnnotationAttributes(metaAnnotation);
            if (!CollectionUtils.isEmpty(annotationAttributes)) {
                annotationAttributes.forEach((k, v) -> System.out.printf("注解:%s,属性 :%s = %s\n", metaAnnotation, k, v));
            }
        });
    }
    public static void test7(){
//        AnnotatedElement annotatedElement=TransactionalServiceBean.class;
        AnnotatedElement annotatedElement=TransactionalServiceBootstrap.class;

        AnnotationAttributes mergedAnnotationAttributes = AnnotatedElementUtils.getMergedAnnotationAttributes(annotatedElement, TransactionalService.class);
        AnnotationAttributes mergedAnnotationAttributes2 = AnnotatedElementUtils.getMergedAnnotationAttributes(annotatedElement, Service.class);
        AnnotationAttributes mergedAnnotationAttributes3 = AnnotatedElementUtils.getMergedAnnotationAttributes(annotatedElement, Transactional.class);
        System.out.println();
    }
    public static void test8(){

        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(TransactionalServiceBootstrap.class);
        Map<String, TransactionalServiceBean> beansOfType = context.getBeansOfType(TransactionalServiceBean.class);
        System.out.println(beansOfType);
        context.close();
    }
}
