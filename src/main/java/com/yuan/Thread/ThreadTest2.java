package com.yuan.Thread;

public class ThreadTest2 extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println("我是子线程2");
        }
    }
}
