package com.example.bootstrap.example7;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

public class EnableServerSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {

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

        return importClasses;
    }
}
