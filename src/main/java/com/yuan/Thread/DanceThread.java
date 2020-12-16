package com.yuan.Thread;

public class DanceThread {
    private static String s1 = "韩红";
    private static String s2 = "舞伴一";
    private static String s3 = "舞伴二";
    private static String s4 = "舞伴三";
    private static int i = 0;

    public static void main(String[] args) {
        Thread t1 = new Thread(s1){
            @Override
            public void run() {
                    while (i < 10) {
                        System.out.println(getName() + "正在唱歌");
                        i++;
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
            }
        };
        Thread t2 = new Thread(s2){
            @Override
            public void run() {
                    while (i < 10) {
                        System.out.println(getName() + "正在伴舞");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
            }
        };
        t2.start();
        Thread t3 = new Thread(s3){
            @Override
            public void run() {
                    while (i < 10) {
                        System.out.println(getName() + "正在伴舞");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
            }
        };
        t3.start();
        Thread t4 = new Thread(s4){
            @Override
            public void run() {
                    while (i < 10) {
                        System.out.println(getName() + "正在伴舞");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
            }
        };
        t4.start();
        t1.start();
    }
}
