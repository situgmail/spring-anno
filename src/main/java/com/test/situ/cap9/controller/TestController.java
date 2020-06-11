package com.test.situ.cap9.controller;

import com.test.situ.cap9.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @Classname TestController
 * @Description TODO
 * @Date 2020/6/2 18:14
 * @Created by glsitu
 * @Version 1.0
 */
@Controller
public class TestController {

    @Autowired
    private TestService testService;

}
