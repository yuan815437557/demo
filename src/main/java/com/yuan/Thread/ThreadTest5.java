package com.yuan.Thread;

public class ThreadTest5 {
    public static void main(String[] args) {
//        new Thread("线程一"){
//            @Override
//            public void run() {
//                while (true){
//                    System.out.println(this.getName());
//                }
//            }
//        }.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    System.out.println(Thread.currentThread().getName());
                }
            }
        }).start();
    }
}
