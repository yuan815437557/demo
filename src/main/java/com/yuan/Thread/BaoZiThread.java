package com.yuan.Thread;

/**
 *需求: 现有一个包子铺, 有两名员工在不停的做包子, 一秒钟做一个, 当包子铺的包子总数达到100的时候,
 *     停止做包子. 现有多名顾客同时吃包子, 当包子已经吃完的时候, 等着员工生产包子, 当有了包子就继续吃
 * */
public class BaoZiThread {
    private static int baoZi = 100;

    public static void main(String[] args) {

        Thread producer1 = new Thread("员工一"){
            @Override
            public void run() {
                while (baoZi < 100){
                    baoZi++;
                    System.out.println(getName() + "做了一个包子");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (baoZi > 50){
                        Thread.yield();
                    }
                }
            }
        };
        Thread producer2 = new Thread("员工二"){
            @Override
            public void run() {
                while (baoZi < 100){
                    baoZi++;
                    System.out.println(getName() + "做了一个包子");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (baoZi > 50){
                        Thread.yield();
                    }
                }
            }
        };
        Thread consumer1 = new Thread("顾客一"){
            @Override
            public void run() {
                while (baoZi > 0){
                    baoZi--;
                    if (baoZi == 0){
                        try {
                            producer1.join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(getName() + "吃了一个包子");
                }
            }
        };
        Thread consumer2 = new Thread("顾客二"){
            @Override
            public void run() {
                while (baoZi > 0){
                    baoZi--;
                    if (baoZi == 0){
                        try {
                            producer1.join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(getName() + "吃了一个包子");
                }
            }
        };
        consumer1.start();
        consumer2.start();
        producer1.start();
        producer2.start();
    }
}
