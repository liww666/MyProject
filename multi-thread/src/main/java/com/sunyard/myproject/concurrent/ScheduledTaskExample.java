package com.sunyard.myproject.concurrent;

import java.util.concurrent.*;

/**
 * Created by Administrator on 2018/8/17.
 */
public class ScheduledTaskExample {
    public static void main(String[] args){
        ScheduledExecutorService scheduledExecutorService=Executors.newSingleThreadScheduledExecutor();
        long start=System.currentTimeMillis();
        Callable<Integer> task=new Callable() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(5000);
                return 100;
            }
        };
        ScheduledFuture<Integer> future=scheduledExecutorService.schedule(task, 1, TimeUnit.SECONDS);
        try {
            Integer result=future.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        long end=System.currentTimeMillis();
        System.out.println("delay :"+(end-start)+"ms");
        scheduledExecutorService.shutdown();
    }
}
