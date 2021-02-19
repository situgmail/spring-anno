package com.test.situ.test.thread.student;

/**
 * @Classname Punishment
 * @Description TODO
 * @Date 2021/1/11 18:34
 * @Created by glsitu
 * @Version 1.0
 */
public class Punishment {

    private int leftCopeCount;
    private String wordToCopy;

    public Punishment(int leftCopeCount, String wordToCopy){
        this.leftCopeCount = leftCopeCount;
        this.wordToCopy = wordToCopy;
    }

    public int getLeftCopeCount() {
        return leftCopeCount;
    }

    public void setLeftCopeCount(int leftCopeCount) {
        this.leftCopeCount = leftCopeCount;
    }

    public String getWordToCopy() {
        return wordToCopy;
    }

    public void setWordToCopy(String wordToCopy) {
        this.wordToCopy = wordToCopy;
    }
}
