package com.example.jvmstudy.book.chapter2;

/**
 * JDK 6
 *  intern()方法会把首次遇到的字符串实例复制到永久代的字符串常量池中存储，返回的也是永久代里面这个字符串实例的引用，
 *  而由StringBuilder创建的字符串对象实例在Java堆上，所以必然不可能是同一个引用，结果将返回false
 *
 * JDK 7中：
 *  字符串常量池已经移到Java堆中，那只需要在常量池里记录一下首次出现的实例引用即可，
 *  因此intern()返回的引用和由StringBuilder创建的那个字符串实例就是同一个。
 *
 *  而对str2比较返回false，这是因为“java”[2]这个字符串在执行String-Builder.toString()之前就已经出现过了，字符串常量
 *  池中已经有它的引用，不符合intern()方法要求“首次遇到”的原则，“计算机软件”这个字符串则是首次出现的，因此结果返回true。
 *
 *
 */
public class RuntimeConstantPoolOOM_2 {

    public static void main(String[] args) {
        /**
         * jdk 7中 把计算机软件 字符串引用
         */
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);

        /**
         * 字符串 常量池 中本来就有 java 这个字符串 直接返回其引用
         */
        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);
    }
}
