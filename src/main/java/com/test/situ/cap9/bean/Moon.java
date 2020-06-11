package com.test.situ.cap9.bean;

import org.springframework.stereotype.Component;

/**
 * @Classname Moon
 * @Description TODO
 * @Date 2020/6/2 21:34
 * @Created by glsitu
 * @Version 1.0
 */
@Component
public class Moon {

    public Moon(){
        System.out.println("Moon constructor.....");
    }

    public void init(){
        System.out.println("Moon........init......");
    }
    public void destroy(){
        System.out.println("Moon........destroy......");
    }


}
