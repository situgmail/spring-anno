package com.test.situ.cap2.config;

import com.test.situ.cap1.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * @Classname Cap2Config
 * @Description TODO
 * @Date 2020/5/21 11:45
 * @Created by heyca
 */
@Configuration
@ComponentScan(value = "com.test.situ.cap2", includeFilters = {
        @Filter(type = FilterType.CUSTOM, classes = {JohnTypeFilter.class})
}, useDefaultFilters = false)
public class Cap2Config {
    @Bean
    public Person person(){

        System.out.println("bean 创建好了");
        return new Person("kkll",20);
    }
}
