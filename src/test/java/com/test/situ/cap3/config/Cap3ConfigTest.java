package com.test.situ.cap3.config;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Classname Cap3ConfigTest
 * @Description TODO
 * @Date 2020/5/22 14:02
 * @Created by heyca
 */
public class Cap3ConfigTest {

    @Test
    public void TestPerson(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext(Cap3Config.class);

        String[] beanDefinitionNames = annotationConfigApplicationContext.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println("-----> " + name);
        }

        Object bean1 = annotationConfigApplicationContext.getBean("person");
        Object  bean2 = annotationConfigApplicationContext.getBean("person");

        System.out.println(bean1 == bean2);
    }
}