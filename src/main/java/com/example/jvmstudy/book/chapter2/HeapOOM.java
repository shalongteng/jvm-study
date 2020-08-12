package com.example.jvmstudy.book.chapter2;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Args：-Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * HeapDumpOnOutOfMemoryError  参数表示当JVM发生OOM时，自动生成DUMP文件。
 * @author zzm
 */
public class HeapOOM {

    static class OOMObject {
    }

    /**
     * 一般来说，就JDK8而言：
     *
     * -Xmx 的默认值为你当前机器最大内存的 1/4
     * -Xms 的默认值为你当前机器最大内存的 1/64
     * -Xss(设置每个线程的堆栈大小) 默认值好像和平台有关，我们最常用的Linux64位服务器默认值好像是1024k。相同物理内存下，
     * 减小这个值能生成更多的线程，这个参数在高并发的情况下对性能影响比较明显，
     * @param args
     */
    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();

        while (true) {
            list.add(new OOMObject());
        }
    }
}

