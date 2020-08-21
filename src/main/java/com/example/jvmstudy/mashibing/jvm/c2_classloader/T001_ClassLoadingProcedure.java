package com.example.jvmstudy.mashibing.jvm.c2_classloader;

public class T001_ClassLoadingProcedure {
    public static void main(String[] args) {
        System.out.println(T.count);
//        System.out.println(new T());
    }
}

class T {
    //在这里 new对象 会调用构造器
    public static T t = new T(); // 执行到这一步时，count仍然是默认值0，调用构造方法后，count变为1,
    public static int count = 2; // 执行到这一步时，上一行的count=1被这一行的count=2覆盖
    /**
     * 准备阶段：
     *  这时候进行内存分配的仅包括类变量，而不包括实例变量，实例变量将会在对象实例化时随着对象一起分配在Java堆中。
     *     这里所说的初始值“通常情况”下是数据类型的零值，
     */

    /**
     * 类加载完了，实例变量分配内存，进行初始化。但是此时类还没有初始化。
     */
    private int m = 8;

    T() {
        System.out.println("m--" + m);
        System.out.println("count--" + count);
        count ++;
        System.out.println("count--" + count);
    }
}
