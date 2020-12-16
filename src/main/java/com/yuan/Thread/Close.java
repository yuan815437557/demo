package com.yuan.Thread;

import java.io.IOException;

public class Close {
    public static void main(String[] args) throws IOException {
        Runtime runtime = Runtime.getRuntime();

//        runtime.exec("shutdown -s -t 300");
        runtime.exec("shutdown -a");
    }
}
