package com.test.situ.cap1;

import com.test.situ.cap1.config.MainConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Classname MyTest
 * @Description TODO
 * @Date 2020/5/21 11:10
 * @Created by heyca
 */
public class MyTest {

      public static void main(String[] args) {
        // 测试类
        //    ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        //    Person person = (Person) context.getBean("person");

        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        Person person = (Person) context.getBean("abcPerson");
        System.out.println(person);

        String[] namesForBean = context.getBeanNamesForType(Person.class);
        for (String name : namesForBean) {
      System.out.println(name);
        }

      }

}
