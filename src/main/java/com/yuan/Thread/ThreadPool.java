package com.yuan.Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "线程执行了");
            }
        };
        ExecutorService es = Executors.newCachedThreadPool();
        es.submit(runnable);
        es.submit(runnable);
        es.shutdown();
    }
}
