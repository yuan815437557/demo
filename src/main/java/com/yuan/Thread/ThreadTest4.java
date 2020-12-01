package com.yuan.Thread;

public class ThreadTest4 implements Runnable {

    private int num = 0;

    @Override
    public void run() {
        while (num < 10){
            System.out.println("我是实现Runnable接口的线程");
            num++;
        }
    }

    public static void main(String[] args) {
        ThreadTest4 threadTest4 = new ThreadTest4();
        Thread thread = new Thread(threadTest4);
//        Thread thread1 = new Thread(threadTest4);

        thread.start();
        System.out.println(thread.getName());
//        thread1.start();
    }
}
