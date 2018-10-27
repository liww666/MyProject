package com.sunyard.myproject.concurrent;

import java.util.concurrent.*;

/**
 * Future.cancle()必须对应Callable;
 * Callable不能自己处理中断异常，否则取消任务不起作用;
 * 不能直接通过Callable创建线程,可以通过FutureTask将Callable转成Runable对象
 * Created by Administrator on 2018/10/27.
 */
public class FutureAndCallableTest {
    public static void main(String[] args) throws InterruptedException {
        Runnable task=new Runnable() {
            @Override
            public void run() {
                while(true){
                    System.out.println(" task is running...");
//                    try {
//                        Thread.sleep(500);
//                    } catch (InterruptedException e) {
//                        System.out.println("task is interrupted...");
//                        Thread.currentThread().interrupt();
//                        throw e;
//                    }
                }
            }
        };
        Callable<Object> callable=new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                for(int i=0;i<100;i++){
                    System.out.println("call times:" + i);
//                    try {
                        Thread.sleep(500);
//                    }catch (InterruptedException e){
                        //自己处理中断异常会导致future.cancle()不起作用
                        System.out.println(" callable is interrupted");
//                    }

                }
                return null;
            }
        };
//        ExecutorService executor= Executors.newScheduledThreadPool(1);
//        Future future=executor.submit(callable);
        FutureTask task1=new FutureTask(callable);
        new Thread(task1).start();
        Thread.sleep(800);
//        future.cancel(true);
        task1.cancel(true);
    }
}
