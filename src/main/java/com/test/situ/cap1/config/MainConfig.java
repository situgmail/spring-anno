package com.test.situ.cap1.config;

import com.test.situ.cap1.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Classname MainConfig
 * @Description TODO
 * @Date 2020/5/21 11:19
 * @Created by heyca
 */
@Configuration
public class MainConfig {

    @Bean("abcPerson")
    public Person person(){
        return new Person("kkll",20);
    }
}
