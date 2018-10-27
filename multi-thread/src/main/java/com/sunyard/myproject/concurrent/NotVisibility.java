package com.sunyard.myproject.concurrent;

/**
 * Created by Administrator on 2018/8/5.
 */
public class NotVisibility {
    public static  boolean state;
    public static  volatile int num;
    public static void main(String[] args) throws InterruptedException {
        new Thread(){
            public void run(){
                while(!state){
                    System.out.println(num);
                }
                System.out.println(num);
            }
        }.start();
        Thread.sleep(1000);
        state=true;
        num=66;
        Thread.yield();
    }

}
