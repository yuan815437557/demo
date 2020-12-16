package com.yuan.Thread;

public class KuaiZiThread {

    private static String s1 = "筷子左";
    private static String s2 = "筷子右";

    public static void main(String[] args) {
        new Thread("线程一"){
            @Override
            public void run() {
                while (true){
                    synchronized (s2){
                        System.out.println(getName() + "已经有了" + s2 + "等待" + s1 + "......");
                        synchronized (s1){
                            System.out.println(getName() + "开始吃饭");
                        }
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }.start();
        new Thread("线程二"){
            @Override
            public void run() {
                while (true){
                    synchronized (s1){
                        System.out.println(getName() + "已经有了" + s1 + "等待" + s2 + "......");
                        synchronized (s2){
                            System.out.println(getName() + "开始吃饭");
                        }
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }.start();
    }
}
