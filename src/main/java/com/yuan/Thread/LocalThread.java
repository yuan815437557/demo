package com.yuan.Thread;

public class LocalThread {
    static ThreadLocal<String> local = new ThreadLocal<>();

    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run() {
                while (true){
                local.set("你");
                method();}
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                while (true){
                local.set("好");
                method();}
            }
        }.start();
    }

    private static void method() {
        System.out.println(local.get());
    }
}
