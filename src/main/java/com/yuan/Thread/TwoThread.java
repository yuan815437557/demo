package com.yuan.Thread;

public class TwoThread {
    public static void main(String[] args) {
        new Thread(){
            private String string;
            @Override
            public void run() {
                synchronized (Class.class){
                    while (true){
                        Class.class.notify();
                        System.out.println("线程一......");
                        try {
                            Class.class.wait(500);
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                synchronized (Class.class){
                    Class.class.notify();
                    System.out.println("线程二......");
                    try {
                        Class.class.wait(500);
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                synchronized (Class.class){
                    Class.class.notify();
                    System.out.println("线程三......");
                    try {
                        Class.class.wait(500);
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}
