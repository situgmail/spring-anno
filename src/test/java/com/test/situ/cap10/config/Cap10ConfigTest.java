package com.test.situ.cap10.config;

import com.test.situ.cap10.aop.Calculator;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;

/**
 * @Classname Cap10ConfigTest
 * @Description TODO
 * @Date 2020/6/3 20:34
 * @Created by glsitu
 * @Version 1.0
 */
public class Cap10ConfigTest {

    @Test
    public void doTest(){
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(Cap10Config.class);
        Calculator calculator = app.getBean(Calculator.class);
        calculator.div(10, 0);
        app.close();
    }


    private void doCase(){

    }
}