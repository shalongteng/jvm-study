#1、HotSpot虚拟机插件及工具
    Ideal Graph Visualizer：用于可视化展示C2即时编译器是如何将字节码转化为理想图，然后转化为机器码的。
    
    ·Client Compiler Visualizer[1]：用于查看C1即时编译器生成高级中间表示（HIR），转换成低级中
        间表示（LIR）和做物理寄存器分配的过程。
    ·MakeDeps：帮助处理HotSpot的编译依赖的工具。
    ·Project Creator：帮忙生成Visual Studio的.project文件的工具。
    ·LogCompilation：将-XX：+LogCompilation输出的日志整理成更容易阅读的格式的工具。
    
#2、HSDIS：即时编译器的反汇编插件。
