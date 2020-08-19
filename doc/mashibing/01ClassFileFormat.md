# JVM

## 1：JVM基础知识
    1. 什么是JVM
        java virtual machine
    2. 常见的JVM
        1996 sun发布jdk1.0 ，这个jdk带的虚拟机就是 classic vm
        HotSpot VM
        BEA JRockit/IBM J9 VM
## 2：ClassFileFormat
    Class文件结构
    魔数，版本号，常量池

## 3：类编译-加载-初始化
    加载，验证，准备，解析，初始化，使用，卸载
    
    对象头：
        Mark word    8个字节
            hashcode
            锁的信息（2位 四种组合）
            GC信息（年龄）
            如果是数组，数组的长度
        klass word   8个字节 16字节（压缩 非压缩）JVM参数指定压缩或非压缩
            类型指针指向对象所属类（元数据）的指针，
            JVM通过这个确定这个对象属于哪个类。
        array length
    实例数据
    对齐填充
        对象地址必须是8字节整数倍。
## 4：JMM
    JMM即为JAVA 内存模型（java memory model）
    
    new Cat()
    pointer -> Cat.class
    寻找方法的信息

## 5：访问对象
    1：句柄池 （指针池）间接指针，节省内存
    2：直接指针，访问速度快

## 6：对象分配
    栈上分配 - > TLAB（Thread Local Allocation Buffer）- > Old  - > Eden - > 老不死 - > Old
    
## 7：GC常用垃圾回收器
    十种垃圾收集器
        serial 
        parallel 
        parNew
        serial old   
        parallel old
        cms
        G1
        ZGC
        Shenandoah
        Epsilon
    

