package com.test.situ.test.thread;

import com.test.situ.test.thread.student.Punishment;
import com.test.situ.test.thread.student.Student;

/**
 * @Classname RunnableSample
 * @Description TODO
 * @Date 2021/1/11 18:48
 * @Created by glsitu
 * @Version 1.0
 */
public class RunnableSample {

      public static void main(String[] args) {

          Punishment punishment = new Punishment(100, "internationalization");
          Student student = new Student("小明", punishment);

          Thread xiaoming = new Thread(student);
          xiaoming.start();
      }
}
