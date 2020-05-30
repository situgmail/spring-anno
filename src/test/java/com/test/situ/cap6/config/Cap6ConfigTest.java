package com.test.situ.cap6.config;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/**
 * @Classname Cap6ConfigTest
 * @Description TODO
 * @Date 2020/5/22 20:36
 * @Created by heyca
 */
public class Cap6ConfigTest {

    @Test
    public void Test01(){


        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(Cap6Config.class);
        System.out.println("IOC容器创建。。。。。");
        String[] names = app.getBeanDefinitionNames();

        Object bean1 = app.getBean("com.test.situ.cap6.config.ALiangFactory");
        System.out.println("bean的类型"  + bean1.getClass());

        for (String name  : names   ) {
            System.out.println(name);
        }

    }

}