package com.test.situ.cap5.config;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @Classname WinConfig
 * @Description 继承条件接口，判断条件 可以使用加载组件 是否 需要加载到容器中
 * @Date 2020/5/22 20:14
 * @Created by heyca
 */
public class WinConfig implements Condition {

    /**
     *
     * @param context 判断条件可以使用上下文
     * @param metadata 注解信息
     * @return
     */
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {


        /**
         * FactoryBean 把Java实例Bean通过FactoryBean 注入到容器中
         * BeanFactory 从我们容器中获取实例化后的bean
         * 获取到IOC容器正在使用的beanFactory
         */
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();

        // 获取环境变量（包含我们操作系统是WIN还是LINUX）
        Environment environment = context.getEnvironment();

        // 获取操作系统的名称
        String osName = environment.getProperty("os.name");;

        if(osName.contains("Windows")){
            return true;
        }

        return false;
    }
}
