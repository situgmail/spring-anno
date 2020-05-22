package com.test.situ.cap4.config;

import com.test.situ.cap1.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * @Classname Cap4Config
 * @Description TODO
 * @Date 2020/5/22 19:09
 * @Created by heyca
 */
@Configuration
public class Cap4Config {

    /**
     * 给容器中注册一个bean，类型为返回值类型，默认是单实例
     * 懒加载：主要针对单实例bean：默认再容器启动时创建对象
     * 懒加载：容器启动时不创建对象，仅当第一次使用（获取）bean的时候才创建被初始化
     * @return
     */
    @Bean
    @Lazy
    public Person person(){
        System.out.println("bean对象创建成功了。。。");
        return new Person("aaa", 20);
    }
}
