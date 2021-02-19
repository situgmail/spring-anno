package com.test.situ.test.thread.student;

/**
 * @Classname Student
 * @Description TODO
 * @Date 2021/1/11 18:34
 * @Created by glsitu
 * @Version 1.0
 */
public class Student extends Thread {

    private String name;
    private Punishment punishment;

    public Student(String name, Punishment punishment){
        super(name);
        this.name = name;
        this.punishment = punishment;
    }

    public void copyWord(){

        int count = 0;

        String threadName = Thread.currentThread().getName();

        while (true){
            if (punishment.getLeftCopeCount() > 0){
                int leftCopyCount = punishment.getLeftCopeCount();
                System.out.println(threadName + "线程-" + name + "抄写" + punishment.getWordToCopy() + "。还要抄写"  + --leftCopyCount + "次");
                punishment.setLeftCopeCount(leftCopyCount);
                count ++;
            }
            else{
                break;
            }
        }

        System.out.println(threadName+"线程-"+name + "一共抄写了" + count + "次！");
    }

    @Override
    public void run() {
        copyWord();
    }
}
