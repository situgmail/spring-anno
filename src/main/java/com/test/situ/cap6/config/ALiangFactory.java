package com.test.situ.cap6.config;

import com.test.situ.cap6.bean.Monkey;
import org.springframework.beans.factory.FactoryBean;

/**
 * @Classname ALiangFactory
 * @Description TODO
 * @Date 2020/5/22 21:11
 * @Created by heyca
 */
public class ALiangFactory implements FactoryBean<Monkey> {

    public Monkey getObject() throws Exception {
        return new Monkey();
    }

    public Class<?> getObjectType() {
        return Monkey.class;
    }

    public boolean isSingleton() {
        return true;
    }
}
