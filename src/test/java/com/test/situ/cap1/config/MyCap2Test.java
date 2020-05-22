package com.test.situ.cap1.config;

import com.test.situ.cap1.Person;
import com.test.situ.cap2.config.Cap2Config;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Classname MyCap2Test
 * @Description TODO
 * @Date 2020/5/21 12:05
 * @Created by heyca
 */
public class MyCap2Test {

    @Test()
    public void Test01(){
        AnnotationConfigApplicationContext app
                = new AnnotationConfigApplicationContext(Cap2Config.class);

        System.out.println("容器启动完成。。。。");
        app.getBean("person");
        String[] names = app.getBeanDefinitionNames();   // 获取所有注入的对象，因为config加入了扫描，自动注入
        for (String name : names) {
            System.out.println(name);
        }

    }

    @Test
    public void Test02(){
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(Cap2Config.class);

        Person person = (Person) context.getBean("person");
        System.out.println(person);
        String[] names = context.getBeanNamesForType(Person.class);
        for (String name : names) {
            System.out.println(name);
        }
    }
}