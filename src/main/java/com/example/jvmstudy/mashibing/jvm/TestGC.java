package com.example.jvmstudy.mashibing.jvm;

public class TestGC {
    public static void main(String[] args) {
        for(;;) {
            new Object();
        }
    }
}
