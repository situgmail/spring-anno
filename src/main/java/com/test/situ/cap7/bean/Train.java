package com.test.situ.cap7.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @Classname Train
 * @Description TODO
 * @Date 2020/6/1 17:17
 * @Created by glsitu
 * @Version 1.0
 */
//@Component
public class Train implements InitializingBean, DisposableBean {

    public Train(){
        System.out.println("Train ...... constructor...");
    }

    // DisposableBean 单例的bean 由bean工厂去执行销毁
    public void destroy() throws Exception {
        System.out.println("Train ...... destroy...");
    }


    // InitializingBean bean所有属性设置和初始化完成之后，才执行这个
    public void afterPropertiesSet() throws Exception {
        System.out.println("Train ...... afterPropertiesSet...");
    }
}
