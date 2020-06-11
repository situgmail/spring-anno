package com.test.situ.cap7.config;

import com.test.situ.cap7.bean.Bike;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Classname LifeCycleConfig
 * @Description TODO
 * @Date 2020/5/30 17:11
 * @Created by glsitu
 * @Version 1.0
 */
@Configuration
@ComponentScan("com.test.situ.cap7.bean")
public class LifeCycleConfig {

    //@Scope("prototype")
    @Bean(initMethod = "init", destroyMethod = "destory")
    public Bike bike(){
        System.out.println("Bike bean 创建。。。。");
        return  new Bike();
    }


}
