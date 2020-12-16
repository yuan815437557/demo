package com.yuan.Thread;

public class LoversThread {
    private static String s1 = "男";
    private static String s2 = "女";

    public static void main(String[] args) {
        new Thread(s1){
            @Override
            public void run() {
                while (true){
                    synchronized (LoversThread.class){
                        System.out.println(getName() + "拿到勺子在吃");
                    }
                }
            }
        }.start();
        new Thread(s2){
            @Override
            public void run() {
                while (true){
                    synchronized (LoversThread.class){
                        System.out.println(getName() + "拿到勺子在吃");
                    }
                }
            }
        }.start();
    }
}
