package com.test.situ.cap5.config;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;

/**
 * @Classname Cap5ConfigTest
 * @Description TODO
 * @Date 2020/5/22 20:12
 * @Created by heyca
 */
public class Cap5ConfigTest {

    /**
     * IOC 对Bean进行管理，bean注册，实例化，管理
     */
    @Test
    public void TestCap5(){
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(Cap5Config.class);

        System.out.println("容器启动完成。。。");
    }

}