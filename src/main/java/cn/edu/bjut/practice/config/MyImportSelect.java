package cn.edu.bjut.practice.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelect implements ImportSelector {
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"cn.edu.bjut.practice.config.AppConfig","cn.edu.bjut.practice.config.MyCorsConfiguration",
                            "cn.edu.bjut.jwt.JWTUtils"};
    }
}
