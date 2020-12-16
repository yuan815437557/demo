package com.yuan.Thread;

public class Money {
    public static void main(String[] args) {
        final int[] money = {1000};
        Thread t1 = new Thread(){
            @Override
            public void run() {
                synchronized (Money.class){
                    while (true){
                    while (money[0] > 0){
                        System.out.println("小明花了100元");
                        money[0] -= 100;
                    }
                    try {
                        Money.class.wait();
                        Money.class.notify();
                        System.out.println("小明又有钱了");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    }
                }
            }
        };
        t1.start();
        Thread t2 = new Thread(){
            @Override
            public void run() {
                synchronized (Money.class){
                    while (true){
                        money[0] += 1000;
                        System.out.println("爸爸冲了1000块钱");
                        Money.class.notify();
                        try {
                            Money.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
        t2.start();
    }
}
