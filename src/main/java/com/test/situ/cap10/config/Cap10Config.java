package com.test.situ.cap10.config;

import com.test.situ.cap10.aop.Calculator;
import com.test.situ.cap10.aop.LogAop;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Classname Cap10Config
 * @Description TODO
 * @Date 2020/6/3 0:04
 * @Created by glsitu
 * @Version 1.0
 */
@Configuration
@EnableAspectJAutoProxy
public class Cap10Config {

    @Bean
    public Calculator calculator(){
        return new Calculator();
    }

    @Bean
    public LogAop logAop(){
        return new LogAop();
    }
}
