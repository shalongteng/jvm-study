package com.example.jvmstudy.mashibing.jvm.c2_classloader;

import sun.misc.Launcher;

public class T002_ClassLoaderLevel {
    public static void main(String[] args) {
        //rt.jar
        System.out.println(String.class.getClassLoader());
        System.out.println(sun.awt.HKSCS.class.getClassLoader());

        System.out.println(sun.net.spi.nameservice.dns.DNSNameService.class.getClassLoader());
        System.out.println(T002_ClassLoaderLevel.class.getClassLoader());


        System.out.println(sun.net.spi.nameservice.dns.DNSNameService.class.getClassLoader().getClass().getClassLoader());
        //AppClassLoader的父亲是 bootstrap loader
        System.out.println(Launcher.getLauncher().getClassLoader().getClass().getClassLoader());

        System.out.println(new T006_MSBClassLoader().getParent());
        System.out.println(ClassLoader.getSystemClassLoader());
    }
}
