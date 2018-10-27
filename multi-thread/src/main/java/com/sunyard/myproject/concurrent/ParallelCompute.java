package com.sunyard.myproject.concurrent;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 并行计算1+2+...+100
 * Created by Administrator on 2018/10/27.
 */
public class ParallelCompute {
    public static void main(String[] args) {
        List<Future<Integer>> futureList=new LinkedList<>();
        int total=0;
        ExecutorService executor = null;
        try {
            executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() + 1);
            for (int i = 1; i <= 100; i++) {
                if (i % 2 == 0) {
                    Future<Integer> future=executor.submit(new MyCallable(i - 1, i));
                    futureList.add(future);
                }
            }
        } finally {
            executor.shutdown();
        }
        for(Future<Integer> future:futureList){
            try {
                total+=future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println("total:"+total);


    }

    static class MyCallable implements Callable<Integer> {
        private Integer a;
        private Integer b;

        public MyCallable(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public Integer call() throws Exception {
            System.out.println("compute :" + a + "+" + b);
            return a + b;
        }
    }

}
