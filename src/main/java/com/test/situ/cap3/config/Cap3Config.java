package com.test.situ.cap3.config;

import com.test.situ.cap1.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @Classname Cap3Config
 * @Description TODO
 * @Date 2020/5/22 13:59
 * @Created by heyca
 */
@Configuration
public class Cap3Config {

    /**
     * prototype:多实例：IOC容器启动的时候，IOC容器启动并不会去调用方法创建对象，而是每次获取的时候，才会调用方法创建对象
     * singleton:单实例：IOC容器启动的时候，会调用方法创建对象并放入IOC容器中，以后每次获取的都是直接从容器中拿（大map.get）的同一个bean
     * request:主要针对web应用，递交一次请求创建一个实例
     * session:同一个session创建一个实例
     * @return
     */
    @Scope("prototype")
    @Bean
    public Person person(){
        return new Person("kkll", 20);
    }
}
