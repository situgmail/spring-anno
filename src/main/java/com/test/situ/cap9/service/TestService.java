package com.test.situ.cap9.service;

import com.test.situ.cap9.dao.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @Classname TestService
 * @Description TODO
 * @Date 2020/6/2 18:15
 * @Created by glsitu
 * @Version 1.0
 */
@Service
public class TestService {

    //@Autowired
    @Qualifier("testDao")
    @Autowired
    //@Inject
    private TestDao dao;  //如果

    public void println(){
        System.out.println("service ... ." + dao.toString());
    }


}
