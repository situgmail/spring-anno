package com.test.situ.cap1;

/**
 * @Classname Person
 * @Description TODO
 * @Date 2020/5/21 11:01
 * @Created by heyca
 */
public class Person {
    private String name;
    private  int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }
    public Person(){

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
