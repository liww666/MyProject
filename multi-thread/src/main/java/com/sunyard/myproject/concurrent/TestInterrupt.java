package com.sunyard.myproject.concurrent;

/**
 * Created by Administrator on 2018/8/13.
 */
public class TestInterrupt {
    public static void main(String[] args) throws InterruptedException {
        Thread t=new Thread(){
          public void run(){
              int i=0;
              while (true){
                  System.out.println(Thread.currentThread().getName()+":"+i++);
                  if(this.isInterrupted()){
                    System.out.println("I am interrupted!");
                      break;
                  }
              }
          }
        };
        t.start();
        Thread.sleep(500);
        t.interrupt();
    }
}
