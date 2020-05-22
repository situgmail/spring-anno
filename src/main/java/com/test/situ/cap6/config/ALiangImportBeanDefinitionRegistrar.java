package com.test.situ.cap6.config;

import com.test.situ.cap6.bean.Pig;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Classname ALiangImportBeanDefinitionRegistrar
 * @Description TODO
 * @Date 2020/5/22 20:55
 * @Created by heyca
 */
public class ALiangImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    /**
     *
     * @param AnnotationMetadata ：当前类的注解信息
     * @param BeanDefinitionRegistry 注册类
     *                               把所有需要添加到容器中的Bean加入
     * @param importBeanNameGenerator
     */
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry, BeanNameGenerator importBeanNameGenerator) {
        boolean b1 = registry.containsBeanDefinition("com.test.situ.cap6.bean.Dog");
        boolean b2 = registry.containsBeanDefinition("com.test.situ.cap6.bean.Cat");

        // 对于我们要注册的bean ,需要给bean进行封装
        if (b1 && b2){
            BeanDefinition beanDefinition = new RootBeanDefinition(Pig.class);
            registry.registerBeanDefinition("pig", beanDefinition);
        }
    }
}
