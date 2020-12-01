package com.yuan.Thread;

public class TuZi extends Thread {

    private int road = 0;

    @Override
    public void run() {
        while (road < 100){
            if (road % 10 == 0){
                System.out.println("兔子跑了" + road);
            }
            if (road == 70){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            road += 10;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("兔子到了");
    }

    public static void main(String[] args) {
        TuZi thread1 = new TuZi();
        WuGui wuGui = new WuGui();
        Thread thread2 = new Thread(wuGui);
        thread1.start();
        thread2.start();
    }
}
