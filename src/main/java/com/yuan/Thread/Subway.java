package com.yuan.Thread;

public class Subway {
    public static void main(String[] args) {
        int[] sum = {100};
        Thread t1 = new Thread(){
            @Override
            public void run() {
                while (sum[0] > 0 && sum[0] <= 100){
                    synchronized (Subway.class){
                        sum[0]--;
                        if (sum[0] == 0){
                            System.out.println("一号口卖出了最后一张票");
                            break;
                        }
                        System.out.println("一号口卖出了第" + (100-sum[0]) + "票");
                    }
                }
            }
        };
        Thread t2 = new Thread(){
            @Override
            public void run() {
                while (sum[0] > 0 && sum[0] <= 100){
                    synchronized (Subway.class){
                        sum[0]--;
                        if (sum[0] == 0){
                            System.out.println("二号口卖出了最后一张票");
                            break;
                        }
                        System.out.println("二号口卖出了第" + (100-sum[0]) + "票");
                    }
                }
            }
        };
        Thread t3 = new Thread(){
            @Override
            public void run() {
                while (sum[0] > 0 && sum[0] <= 100){
                    synchronized (Subway.class){
                        sum[0]--;
                        if (sum[0] == 0){
                            System.out.println("三号口卖出了最后一张票");
                            break;
                        }
                        System.out.println("三号口卖出了第" + (100-sum[0]) + "票");
                    }
                }
            }
        };
        Thread t4 = new Thread(){
            @Override
            public void run() {
                while (sum[0] > 0 && sum[0] <= 100){
                    synchronized (Subway.class){
                        sum[0]--;
                        if (sum[0] == 0){
                            System.out.println("四号口卖出了最后一张票");
                            break;
                        }
                        System.out.println("四号口卖出了第" + (100-sum[0]) + "票");
                    }
                }
            }
        };
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
