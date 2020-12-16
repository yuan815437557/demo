package com.yuan.Thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Reentrant {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition cnl = lock.newCondition();
        new Thread(){
            @Override
            public void run() {
                lock.lock();
                for (int i = 0; i < 10; i++) {
                    cnl.signal();
                    System.out.println("线程一......");
                    try {
                        cnl.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.unlock();
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                lock.lock();
                for (int i = 0; i < 10; i++) {
                    cnl.signal();
                    System.out.println("线程二......");
                    try {
                        cnl.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.unlock();
            }
        }.start();
    }
}
