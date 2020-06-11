package com.test.situ.cap9.dao;

/**
 * @Classname TestDao
 * @Description TODO
 * @Date 2020/6/2 18:15
 * @Created by glsitu
 * @Version 1.0
 */

import org.springframework.stereotype.Repository;

@Repository
public class TestDao {

    private String flag = "1";

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "TestDao{" +
                "flag='" + flag + '\'' +
                '}';
    }
}
