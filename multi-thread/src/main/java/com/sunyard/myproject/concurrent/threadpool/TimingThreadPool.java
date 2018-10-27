package com.sunyard.myproject.concurrent.threadpool;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

/**自定义beforeExcute等方法
 * Created by Administrator on 2018/10/27.
 */
public class TimingThreadPool extends ThreadPoolExecutor {
    public TimingThreadPool(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    private final ThreadLocal<Long> startTime
            = new ThreadLocal<Long>();
//    private final Logger log = Logger.getLogger("TimingThreadPool");
    private final AtomicLong numTasks = new AtomicLong();
    private final AtomicLong totalTime = new AtomicLong();
    protected void beforeExecute(Thread t, Runnable r) {
        super.beforeExecute(t, r);
        System.out.println(String.format("Thread %s: start %s", t, r));
        startTime.set(System.nanoTime());
    }
    protected void afterExecute(Runnable r, Throwable t) {
        try {
            long endTime = System.nanoTime();
            long taskTime = endTime - startTime.get();
            numTasks.incrementAndGet();
            totalTime.addAndGet(taskTime);
            System.out.println(String.format("Thread %s: end %s, time=%dns",
                    t, r, taskTime));
        } finally {
            super.afterExecute(r, t);
        }
    }
    protected void terminated() {
        try {
            System.out.println(String.format("Terminated: avg time=%dns",
                    totalTime.get() / numTasks.get()));
        } finally {
            super.terminated();
        }
    }

    public static void main(String[] args) {
        TimingThreadPool executor=new TimingThreadPool(3,5,5,TimeUnit.MINUTES,new LinkedBlockingQueue<Runnable>(3));
        executor.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" is running...");
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        executor.shutdown();

    }
}
