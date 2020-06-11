package com.test.situ.cap7.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @Classname JohnBeanPostProcessor
 * @Description TODO
 * @Date 2020/6/1 18:04
 * @Created by glsitu
 * @Version 1.0
 */

@Component
public class JohnBeanPostProcessor implements BeanPostProcessor {


    /**
     * 返回一个对象（传过来的对象）
     * 在初始化方法调用之前进行后置处理工作
     * 在init方法之前
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitializatio...... " + beanName + bean);
        return null;
    }

    /**
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization ...... "+ beanName + bean);
        return null;
    }


}
