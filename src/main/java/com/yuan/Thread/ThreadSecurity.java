package com.yuan.Thread;

public class ThreadSecurity {
    public static void main(String[] args) {
        final int[] num = {5};
        Thread t1 = new Thread(){
            @Override
            public void run() {
                while (true){
                    synchronized (Class.class){
                        if (num[0] > 0){
                            System.out.println(getName() + ":" + num[0]--);
                        }else {
                            break;
                        }
                    }
                }
            }
        };
        Thread t2 = new Thread(){
            @Override
            public void run() {
                while (true){
                    synchronized (Class.class) {
                        if (num[0] > 0) {
                            System.out.println(getName() + ":" + num[0]--);
                        } else {
                            break;
                        }
                    }
                }
            }
        };
        t2.setPriority(10);
        t1.setPriority(1);
        t1.start();
        t2.start();
    }
}
