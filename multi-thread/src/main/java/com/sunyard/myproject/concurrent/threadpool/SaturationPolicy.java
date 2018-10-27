package com.sunyard.myproject.concurrent.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池的饱和策略有四种：AbortPolicy, CallerRunsPolicy, DiscardPolicy, and DiscardOldestPolicy
 * Created by Administrator on 2018/10/27.
 */
public class SaturationPolicy {
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor executor=new ThreadPoolExecutor(1,2,3, TimeUnit.MINUTES,new ArrayBlockingQueue<Runnable>(1));
//        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());
        /*
        The caller-runs policy implements a form of throttling that neither discards tasks nor throws an exception,
        but instead tries to slow down the flow of new tasks by pushing some of the work back to the caller.
         */
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        for(int i=0;i<5;i++){
            executor.submit(new Task(String.valueOf(i)));
            Thread.sleep(500);
        }

    }
    static class Task implements Runnable{
        private String name;
        public Task(String name){
            this.name=name;
        }

        @Override
        public void run() {
            while (true){
                System.out.println(Thread.currentThread().getName()+":"+this.name+" is running...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
