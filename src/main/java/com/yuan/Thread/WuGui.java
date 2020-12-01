package com.yuan.Thread;

public class WuGui implements Runnable {

    private int road = 0;

    @Override
    public void run() {
        while (road < 100){
            if (road % 10 == 0){
                System.out.println("乌龟跑了" + road);
            }
            road += 5;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("乌龟到了");
    }
}
