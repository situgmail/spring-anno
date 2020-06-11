package com.test.situ.cap7.bean;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Classname Jeep
 * @Description TODO
 * @Date 2020/6/1 17:27
 * @Created by glsitu
 * @Version 1.0
 */
@Component
public class Jeep {

    public Jeep(){
        System.out.println("Jeep ...... constructor...... ..");
    }

    @PostConstruct
    public void init(){
        System.out.println("Jeep ...... @PostConstruct...... ..");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Jeep ...... @PreDestroy...... ..");
    }
}
