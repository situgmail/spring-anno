package com.test.situ.cap9.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Classname Sun
 * @Description TODO
 * @Date 2020/6/2 21:35
 * @Created by glsitu
 * @Version 1.0
 */
@Component
public class Sun {


    private Moon moon;


    public Sun(@Autowired Moon moon){
        this.moon = moon;
        System.out.println(this.moon);
    }

    public Moon getMoon() {
        return moon;
    }

    public void setMoon(Moon moon) {
        this.moon = moon;
    }

    @Override
    public String toString() {
        return "Sun{" +
                "moon=" + moon +
                '}';
    }
}
