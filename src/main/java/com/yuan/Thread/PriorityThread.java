package com.yuan.Thread;

public class PriorityThread {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("线程一正在运行");
//                    Thread.yield();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("线程二正在运行");
                }
            }
        });
        t1.setPriority(1);
        t2.setPriority(10);
        t2.start();
        t1.start();
    }
}
