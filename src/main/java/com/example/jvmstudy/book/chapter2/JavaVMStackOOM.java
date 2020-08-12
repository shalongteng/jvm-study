package com.example.jvmstudy.book.chapter2;

/**
 * VM Args：-Xss2M （这时候不妨设大些，请在32位系统下运行）
 *
 * 注意　重点提示一下，如果要尝试运行这段代码，记得要先保存当前的工作，由于在
 * Windows平台的虚拟机中，Java的线程是映射到操作系统的内核线程上[1]，无限制地创建线程会对操
 * 作系统带来很大压力，上述代码执行时有很高的风险，可能会由于创建线程数量过多而导致操作系统
 * 假死。
 * @author zzm
 */
public class JavaVMStackOOM {

    private void dontStop() {
        while (true) {
        }
    }

    public void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }

    public static void main(String[] args) throws Throwable {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();
    }
}
