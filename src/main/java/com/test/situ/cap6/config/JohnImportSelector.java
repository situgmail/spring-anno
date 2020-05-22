package com.test.situ.cap6.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Classname JohnImportSelector
 * @Description TODO
 * @Date 2020/5/22 20:43
 * @Created by heyca
 */
public class JohnImportSelector implements ImportSelector {

    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        // 返回全类名的bean
        return new String[]{"com.test.situ.cap6.bean.Fish", "com.test.situ.cap6.bean.Tiger"};
    }


}
