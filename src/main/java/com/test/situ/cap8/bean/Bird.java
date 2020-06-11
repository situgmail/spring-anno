package com.test.situ.cap8.bean;

import org.springframework.beans.factory.annotation.Value;

/**
 * @Classname bird
 * @Description TODO
 * @Date 2020/6/2 17:09
 * @Created by glsitu
 * @Version 1.0
 */
public class Bird {
    @Value("Liang")
    private String name;
    @Value("#{20-2}")
    private Integer age;
    @Value("${bird.color}")
    private String color;

   public Bird(){

   }

    public Bird(String name, Integer age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;

    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Bird{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color=" + color  +
                '}';
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
