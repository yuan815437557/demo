package com.yuan.Thread.title;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class XunHuanThread {
    private static boolean flag = true;
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition cnl = lock.newCondition();
        new Thread(){
            int i = 1;
            int count = 0;
            @Override
            public void run() {
                lock.lock();
                while (i <= 10 && flag){
                    cnl.signal();
                    System.out.println("子线程第" + i + "次循环");
                    if (i == 10){
                        try {
                            cnl.await();
                            i = 0;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    i ++;
                    count ++;
                    if (count/10 == 5){
//                        System.out.println("子线程一共循环了" + count/10 + "次");
                        flag = false;
                        try {
                            throw new Exception();
                        } catch (Exception e) {
                            System.out.println("主线程和子线程一共循环了" + count/10 + "次");
                        }
                    }
                }
                lock.unlock();
            }
        }.start();
        new Thread(){
            int i = 1;
            int count = 0;
            @Override
            public void run() {
                lock.lock();
                    while (i <= 100 && flag) {
                        cnl.signal();
                        System.out.println("主线程第" + i + "次循环");
                        if (i == 100){
                            try {
                                cnl.await();
                                i = 0;
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        i ++;
                        count++;
                        if (count/100 == 5) {
                            System.out.println("主线程一共循环了" + count/100 + "次");
                            flag = false;
                        }
                    }
                lock.unlock();
            }
        }.start();
    }
}
