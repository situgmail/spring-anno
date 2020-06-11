package com.test.situ.cap8.config;

import com.test.situ.cap8.bean.Bird;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @Classname Cap8ConfigTest
 * @Description TODO
 * @Date 2020/6/2 17:12
 * @Created by glsitu
 * @Version 1.0
 */
public class Cap8ConfigTest {

    @Test
    public void doTestCap8(){
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(Cap8Config.class);

        String[] names = app.getBeanDefinitionNames();
        for (String  name : names    ) {
            System.out.println(name);
        }

        Bird bird = (Bird) app.getBean("bird");

        ConfigurableEnvironment environment = app.getEnvironment();
        String property = environment.getProperty("bird.color");
        System.out.println("property ======= " + property);

        System.out.println(bird.toString());
        System.out.println("IOC容器创建.....");

        app.close();
    }

}