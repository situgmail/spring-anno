package com.test.situ.cap4.config;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;

/**
 * @Classname Cap4ConfigTest
 * @Description TODO
 * @Date 2020/5/22 19:13
 * @Created by heyca
 */
public class Cap4ConfigTest {

    @Test
    public void TestCap(){
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(Cap4Config.class);
        System.out.println("容器启动完成。。。。");
        app.getBean("person");
    }
}