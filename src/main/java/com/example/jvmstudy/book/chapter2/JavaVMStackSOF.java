package com.example.jvmstudy.book.chapter2;

/**
 * VM Args：-Xss128k
 * 使用-Xss参数减少栈内存容量
 * 结果：抛出StackOverflowError异常，异常出现时输出的堆栈深度相应大小。
 * 递归压栈，栈溢出。
 * @author zzm
 */
public class JavaVMStackSOF {
    private int stackLength = 1;

    public void stackLeak() {
//        System.out.println(stackLength);
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) throws Throwable {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length:" + oom.stackLength);
            throw e;
        }
    }
}
