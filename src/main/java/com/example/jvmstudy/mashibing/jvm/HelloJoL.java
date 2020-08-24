package com.example.jvmstudy.mashibing.jvm;

import org.openjdk.jol.info.ClassLayout;

/**
 * 测试对象的内存布局 jol
 */
public class HelloJoL {
    public static void main(String[] args) {
        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(0).toPrintable());


        synchronized (o){
            System.out.println(ClassLayout.parseInstance(0).toPrintable());

        }
    }
}
