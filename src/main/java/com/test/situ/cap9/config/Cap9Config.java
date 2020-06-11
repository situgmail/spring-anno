package com.test.situ.cap9.config;

import com.test.situ.cap9.dao.TestDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Classname Cap9Config
 * @Description TODO
 * @Date 2020/6/2 18:13
 * @Created by glsitu
 * @Version 1.0
 */
@Configuration
@ComponentScan({"com.test.situ.cap9.controller", "com.test.situ.cap9.service", "com.test.situ.cap9.dao", "com.test" +
        ".situ.cap9.bean"})
public class Cap9Config {

    // 配置先加载，然后把属性都初始化后，在执行扫描
    //@Primary
    @Bean("testDao2")
    public TestDao testDao(){
        TestDao testDao = new TestDao();
        testDao.setFlag("2");

        return testDao;
    }
}
