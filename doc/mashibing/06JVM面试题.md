#1、美团七连问
    熟悉gc常用算法，熟悉常见的垃圾收集器，具有实际的jvm、调优经验。
    
    关于：Object o = new Object();请解释一下
    1.请解释一下对象创建过程？（半初始化）
        new 指令  半初始化，（赋默认值）
        invoksepcial 调用init 方法
        astore_1  将引用和对象 建立连接
    2.加问DCL与volatile问题？（指令重排）
        volatile作用：
            保持线程可见性
                  主内存中flag发生了变化。会通知线程。
                  线程重新load一下 flag的值。
            禁止指令重排
            
        cpu的乱序执行
            两条指令，指令1 和 指令2
            CPU进行【读等待】同时，执行指令是CPU的乱序的根源，是为了提高效率。
            如果两条指令没有依赖关系，读指令1等待同时，会优先执行指令2.
            
            
    3.对象在内存中的布局？（对象与数组的不同）
        对象头 
            mark word       8个字节
            class pointer   4个字节
            array length
        实例数据
            属性
        对其填充
            8字节对齐
    4.对象头具体包括什么? (markword klasspointer)synchronized锁信息
        mark word
            identity hashcode
            gc
            lock
                偏向锁
                自旋锁
                重量级锁
    5.对象怎么定位? (直接间接)
        句柄池
            他的优点跟gc有关。gc对象复制
            在垃圾回收过程中，不用频繁改动引用的指向。
        直接指针
            速度快
            垃圾回收过程中，引用一直改变。
       
    6.对象怎么分配? ()
        栈上
        线程本地
        Eden
        0ld
    7.object o = new Object()在内存中占用多少字节?
        16
        o引用 4-8
        32g内存以上  o引用膨胀成8个字节
        
    
#2、面试题
    1. -XX:MaxTenuringThreshold控制的是什么？
       A: 对象升入老年代的年龄
    
    2. 生产环境中，倾向于将最大堆内存和最小堆内存设置为：（为什么？）
       A: 相同  防止内存抖动
    
    3. JDK1.8默认的垃圾回收器是：
        C: PS + ParallelOld
    
    4. 什么是响应时间优先？
        STW尽量短
        cms g1
    5. 什么是吞吐量优先？
        吞吐量 = 用户代码时间 /（用户代码执行时间 + 垃圾回收时间）
        ps+po
    6. ParNew和PS的区别是什么？
        parnew可以搭配Cms使用
        ps 吞吐量优先
    7. ParNew和ParallelOld的区别是什么？
        （年代不同，算法不同）
    8. 长时间计算的场景应该选择：
        吞吐量
        
    9. 大规模电商网站应该选择：
        停顿时间 
    
    10. HotSpot的垃圾收集器最常用有哪些？
        serial parNew parallel 
        serial old
        cms
        parallel old
        G1
        ZGC
        SHennadoah
        eplsion
    11. 常见的HotSpot垃圾收集器组合有哪些？
        ps+po
        parNew + cms + serial old
        G1
        
    12. JDK1.7 1.8 1.9的默认垃圾回收器是什么？如何查看？
        java -XX:+PrintCommandLineFlags -version
    13. 所谓调优，到底是在调什么？
        响应时间
        吞吐量
        OOM
        
    14. 如果采用PS + ParrallelOld组合，怎么做才能让系统基本不产生FGC
    
    15. 如果采用ParNew + CMS组合，怎样做才能够让系统基本不产生FGC
         1.加大JVM内存
         2.加大Young的比例
         3.提高Y-O的年龄
         4.提高S区比例
         5.避免代码内存泄漏
    
    16. G1是否分代？G1垃圾回收器会产生FGC吗？
        逻辑分代，物理不分
        
    17. 如果G1产生FGC，你应该做什么？
          1. 扩内存
          2. 提高CPU性能（回收的快，业务逻辑产生对象的速度固定，垃圾回收越快，内存空间越大）
          3. 降低MixedGC触发的阈值，让MixedGC提早发生（默认是45%）
    
     18. 问：生产环境中能够随随便便的dump吗？
         小堆影响不大，大堆会有服务暂停或卡顿（加live可以缓解），dump前会有FGC
    
     19. 问：常见的OOM问题有哪些？
         栈 堆 MethodArea 直接内存


