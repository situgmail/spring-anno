package com.test.situ.test.thread;

import com.test.situ.test.thread.student.Punishment;
import com.test.situ.test.thread.student.Student;

/**
 * @Classname thread
 * @Description TODO
 * @Date 2021/1/11 18:31
 * @Created by glsitu
 * @Version 1.0
 */
public class ThreadSample {

      public static void main(String[] args) {
          Punishment punishment = new Punishment(100, "internationalization");
          Student student = new Student("小明", punishment);
          student.start();


          System.out.println("Another thread will finish the punishment。 main thread is finished" );


      }
}


