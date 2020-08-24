package com.example.jvmstudy.mashibing.jvm.testVolatile;

/**
 * volatile 保持线程可见性
 * JMM
 */
public class Demo01 {
    public static volatile boolean flag = true;
//    public static boolean flag = true;

    /**
     * 不加volatile 的话，server线程并不会停止。
     * 保持线程可见性。
     * JMM
     *  主内存中flag发生了变化。会通知线程。
     *  线程注重重新load一下 flag的值。
     */
    public static void main(String[] args) throws InterruptedException {
        new Thread(
                ()->{
                    while (flag){

                    }
                    System.out.println("end");
                },"server").start();

        Thread.sleep(1000);
        flag = false;
    }

}
