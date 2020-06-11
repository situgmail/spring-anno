package com.test.situ.cap7.config;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;

/**
 * @Classname LifeCycleConfigTest
 * @Description TODO
 * @Date 2020/5/30 17:15
 * @Created by glsitu
 * @Version 1.0
 */
public class LifeCycleConfigTest {

    @Test
    public void doTestConfig(){
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(LifeCycleConfig.class);

        System.out.println("IOC容器创建完成。。。。");

        app.close();
    }

}