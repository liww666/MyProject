package com.sunyard.myproject.concurrent;

/**
 * Created by Administrator on 2018/10/27.
 */
public class InterruptSleep {
    public static void main(String[] args) throws InterruptedException {
        Thread t=new Thread(){
            public void run(){
                System.out.println(" t is running,before sleep...");
                try {
                    //当被中断时，不仅抛出中断异常，还会清除当前线程中断状态
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    this.interrupt();
                }
               if (this.isInterrupted()){
                   System.out.println("t is interrupted");
                }else{
                   System.out.println("t is not interrupted");
               }
            }
        };
        t.start();
        Thread.sleep(1000);
        t.interrupt();
    }

}
