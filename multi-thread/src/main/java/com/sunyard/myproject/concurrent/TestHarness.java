package com.sunyard.myproject.concurrent;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * 闭锁的使用
 * Created by Administrator on 2018/8/10.
 */
public class TestHarness {
    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch startState=new CountDownLatch(1);
        final int num=10;
        final CountDownLatch endState=new CountDownLatch(num);
        final Random random=new Random();
        new Thread(){
            public void run(){
                try {
                    startState.await();
                    for(int i=0;i<num;i++){
                        new Thread(){
                            public void run(){
                                try {
                                    int j= random.nextInt(5000);
                                    System.out.println(Thread.currentThread().getName()+" need: "+j+"ms");
                                    Thread.sleep(j);

                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }finally {
                                    endState.countDown();
                                }

                            }
                        }.start();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }.start();
        long start=System.currentTimeMillis();
        startState.countDown();
        endState.await();
        long end=System.currentTimeMillis();
        System.out.println("spend:"+(end-start)+"ms");
    }
}
