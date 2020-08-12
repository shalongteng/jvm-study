#1、Java堆溢出
    内存泄露
        找到泄漏对象是通过怎样的引用路径、与哪些GC Roots相关联，才导致垃圾收集器无法回收它们。
    内存溢出
        对象过于多
        大对象
    -Xms20m 最小堆内存
    -Xmx20m 最大堆内存 
#2、虚拟机栈和本地方法栈溢出
    1）如果线程请求的栈深度大于虚拟机所允许的最大深度，将抛出StackOverflowError异常。
        递归压栈
    2）如果虚拟机的栈内存允许动态扩展，当扩展栈容量无法申请到足够的内存时，将抛出OutOfMemoryError异常。
        多线程创建，
    HotSpot虚拟机的选择是不支持扩展，在创建线程申请内存时就因无法获得足够内存而出现 OutOfMemoryError异常
    
    使用-Xss参数减少栈内存容量
#3、方法区
    cglib动态创建类
    
#4、运行时常量池溢出
    jdk7以前 string.intern 方法可以触发OutOfMemoryError
        -XX:PermSize=6M -XX:MaxPermSize=6M
        
    jdk7以后 字符串常量池已经移到Java堆中，只能限制堆的大小，才能抛出OutOfMemoryError
    


#5、本机直接内存溢出
    过-XX：MaxDirectMemorySize
    如果内存溢出之后产生的Dump文件很小，而程序中又直接或间接使用了 DirectMemory（典型的间接使用就是NIO）

