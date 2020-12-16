package com.yuan.Thread;

import java.util.Timer;
import java.util.TimerTask;

public class Clock {
    public static void main(String[] args) {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("敲代碼了");
            }
        };
        Timer timer = new Timer();
        timer.schedule(task,5);
    }
}
