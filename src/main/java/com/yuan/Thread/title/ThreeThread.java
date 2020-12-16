package com.yuan.Thread.title;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreeThread {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition cnl = lock.newCondition();
        Thread t1 = new Thread(){
            int i = 10;
            @Override
            public void run() {
                lock.lock();
                while (i > 0){
                    System.out.println("线程一...");
                    cnl.signal();
                    try {
                        cnl.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
//                    i --;
                }
                lock.unlock();
            }
        };
        t1.start();
        Thread t2 = new Thread(){
            @Override
            public void run() {
                int i = 10;
                lock.lock();
                while (i > 0){
                    System.out.println("线程二...");
                    cnl.signal();
                    try {
                        cnl.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
//                    i --;
                }
                lock.unlock();
            }
        };
        t2.start();
        Thread t3 = new Thread(){
            @Override
            public void run() {
                int i = 10;
                while (i > 0){
                    lock.lock();
                    System.out.println("线程三...");
                    cnl.signal();
                    try {
                        cnl.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
//                    i --;
                }
                lock.unlock();
            }
        };
        t3.start();
    }
}
