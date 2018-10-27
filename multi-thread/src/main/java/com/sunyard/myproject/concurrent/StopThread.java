package com.sunyard.myproject.concurrent;

/**
 * Created by Administrator on 2018/7/15.
 */
public class StopThread {
    private static boolean isStop;
    public static void main(String[] args) throws InterruptedException {
        final long start=System.currentTimeMillis();
        new Thread(){
            public void run(){
                int i=0;
                while(!isStop){
                    System.out.println("i="+i++);
                }
                long end=System.currentTimeMillis();
                System.out.println("use:"+(end-start)/1000+"s");
            }
        }.start();

        Thread.sleep(1000);
        isStop=true;
    }
}
