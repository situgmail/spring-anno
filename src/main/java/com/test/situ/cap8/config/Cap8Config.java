package com.test.situ.cap8.config;

import com.test.situ.cap8.bean.Bird;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Classname Cap8Config
 * @Description TODO
 * @Date 2020/6/2 17:08
 * @Created by glsitu
 * @Version 1.0
 */
@Configuration
@PropertySource(value = "classpath:/test.properties")
public class Cap8Config {

    @Bean
    public Bird bird(){
        return new Bird();
    }
}
