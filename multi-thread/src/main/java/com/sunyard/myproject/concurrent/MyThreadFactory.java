package com.sunyard.myproject.concurrent;

import java.util.concurrent.ThreadFactory;

/**
 * Created by Administrator on 2018/8/14.
 */
public class MyThreadFactory implements ThreadFactory {
    private String poolName;
    public MyThreadFactory(String poolName){
        this.poolName=poolName;
    }
    @Override
    public Thread newThread(Runnable r) {
        return new MyAppThread(r,poolName);
    }
    public static void main(String[] args){
        ThreadFactory factory=new MyThreadFactory("MyThreadFactory");
        for(int j=0;j<10;j++){
            factory.newThread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 100; i++) {
                        System.out.println(i);
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
        Thread.yield();

                System.out.println("Created:" + MyAppThread.getCreated() + ",alive:" + MyAppThread.getAlive());



    }
}
