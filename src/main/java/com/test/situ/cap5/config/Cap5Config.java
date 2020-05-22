package com.test.situ.cap5.config;

import com.test.situ.cap1.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @Classname Cap5Config
 * @Description TODO
 * @Date 2020/5/22 20:09
 * @Created by heyca
 */
@Configuration
public class Cap5Config {


    @Bean("person")
    public Person person(){
        System.out.println("给容器中添加 person .......");
        return new Person("john", 20);
    }

    @Bean("situ")
    @Conditional(LinConfig.class)
    public Person situ(){
        System.out.println("给容器中添加 situ .......");
        return new Person("situ", 40);
    }

    @Bean("aLiuang")
    @Conditional(WinConfig.class)
    public Person aLiuang(){
        System.out.println("给容器中添加 aLiuang .......");
        return new Person("aLiuang", 25);
    }
}
