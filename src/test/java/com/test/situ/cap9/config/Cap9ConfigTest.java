package com.test.situ.cap9.config;

import com.test.situ.cap9.bean.Moon;
import com.test.situ.cap9.bean.Sun;
import com.test.situ.cap9.service.TestService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Classname Cap9ConfigTest
 * @Description TODO
 * @Date 2020/6/2 18:18
 * @Created by glsitu
 * @Version 1.0
 */
public class Cap9ConfigTest {

    @Test
    public void  doTest(){
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(Cap9Config.class);

        TestService service = app.getBean(TestService.class);
        service.println();
//
//        TestDao dao = (TestDao)app.getBean("testDao2");
//        System.out.println(dao.toString());

        Moon moon = app.getBean(Moon.class);
        System.out.println(moon);

        Sun sun = app.getBean(Sun.class);
        Moon moon1 = sun.getMoon();
        System.out.println(moon1);

        app.close();
    }

}