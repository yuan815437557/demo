package com.yuan.Thread;

public class ThreadTest3 extends Thread {
    @Override
    public void run() {
        while (true){
            System.out.println("我是子线程3");
        }
    }
}
