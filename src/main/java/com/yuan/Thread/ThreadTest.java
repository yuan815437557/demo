package com.yuan.Thread;

public class ThreadTest extends Thread{

    private int num = 0;

    @Override
    public void run() {
        while (num < 10){
            System.out.println("我是继承Thread的子线程");
            num ++;
        }
    }

    public static void main(String[] args) {
        ThreadTest threadTest = new ThreadTest();
        ThreadTest4 threadTest4 = new ThreadTest4();
        Thread thread = new Thread(threadTest4);
        threadTest.start();
        thread.start();
        System.out.println(thread.getName());
        System.out.println(threadTest.getName());

    }
}
