package com.test.situ.cap7.bean;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Classname Plane
 * @Description TODO
 * @Date 2020/6/2 15:45
 * @Created by glsitu
 * @Version 1.0
 */
@Component
public class Plane implements ApplicationContextAware {

    private ApplicationContext context;
    @PostConstruct
    public void init(){
        System.out.println("Plane.....init....");
    }

    @PreDestroy
    public void destory(){
        System.out.println("Plane.....destory.....");
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        // 将applicationContext拿出来，就可以用
        this.context = applicationContext;
    }
}
