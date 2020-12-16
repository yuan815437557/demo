package com.yuan.Thread;
/**
 * 需求: 现在有T1、T2、T3三个线程，你怎样保证T2在T1执行完后执行，T3在T2执行完后执行？
 * */
public class TThread {
    public static void main(String[] args) {
        Thread t1 = new Thread("t1"){
            int i = 5;
            @Override
            public void run() {
                while (i > 0){
                    System.out.println(getName() + "正在运行");
                    i--;
                }
            }
        };
        Thread t2 = new Thread("t2"){
            int i = 5;
            @Override
            public void run() {
                try {
                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                while (i > 0){
                    System.out.println(getName() + "正在运行");
                    i--;
                }
            }
        };
        Thread t3 = new Thread("t3"){
            int i = 5;
            @Override
            public void run() {
                try {
                    t2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                while (i > 0){
                    System.out.println(getName() + "正在运行");
                    i--;
                }
            }
        };
        t1.start();
        t2.start();
        t3.start();
    }
}
