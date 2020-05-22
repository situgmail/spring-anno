package com.test.situ.cap6.config;

import com.test.situ.cap1.Person;
import com.test.situ.cap6.bean.Cat;
import com.test.situ.cap6.bean.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @Classname Cap6Config
 * @Description TODO
 * @Date 2020/5/22 20:30
 * @Created by heyca
 */
@Configuration
@Import(value = {Dog.class, Cat.class, JohnImportSelector.class, ALiangImportBeanDefinitionRegistrar.class})
public class Cap6Config {

    /**
     * 给容器中注册组件的方式
     * @Bean 的局限性，导入第三方的类或者包的组件，比如person为第三方的类，需要在我们的IOC容器中使用
     * 2,包扫描+组件的标注注解（@CompoentScan: @Controller, @Service, @Reponsitory @Componet）,一般是针对我们自己写的类，使用这个
     * 3，@Import：【快速给容器导入一个组件】 注意：@Bean有点简单
     *      a， @Import（要导入到容器中的组件）：容器会自动注册这个组件，bean的ID 为全类名
     *      b， ImportSelector：是一个接口，返回需要导入到容器的组件的全类名数组
     *      c, ImportBeanDefinitionRegistrar：可以手动添加组件到IOC容器，所有Bean的注册可以使用BeanDifinitionRegistry 写
     *      ALiangImportBeanDefinitionRegistrar 实现 ImportBeanDefinitionRegistrar接口即可
     *  4, 使用Spring提供的FactoryBean 直接注册bean
     */
    // 容器启动时初始化person的bean实例
    @Bean("person")
    public Person person(){
        return new Person("John", 20);
    }

    @Bean
    public ALiangFactory aLiangFactory(){
        return new  ALiangFactory();
    }

}
