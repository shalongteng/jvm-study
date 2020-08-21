## 1：类加载-初始化
    1. Loading
      1. 双亲委派，主要出于安全来考虑
      2. LazyLoading 五种情况
         JVM 运行并不是一次性加载所需要的全部类的，它是按需加载，也就是延迟加载。
         调用某个类的静态方法时，这个类是要被加载的，但是并不会触及这个类的实例字段，
         那么实例字段的类别 Class 就可以暂时不必去加载，
          
        –new getstatic putstatic invokestatic指令，访问final变量除外
        –java.lang.reflect对类进行反射调用时
        –初始化子类的时候，父类首先初始化
        –虚拟机启动时，被执行的主类必须初始化
        –动态语言支持java.lang.invoke.MethodHandle解析的结果为
        REF_getstatic REF_putstatic REF_invokestatic的方法句柄时，该类必须初始化
      
      3. ClassLoader的源码
         1. findInCache -> parent.loadClass -> findClass()
     
      4. 混合执行 编译执行 解释执行
      
         1. 检测热点代码：-XX:CompileThreshold = 10000
      
    2. Linking 
      1. Verification
         1. 验证文件是否符合JVM规定
      2. Preparation
         1. 静态成员变量赋默认值
      3. Resolution
         1. 将类、方法、属性等符号引用解析为直接引用
            常量池中的各种符号引用解析为指针、偏移量等内存地址的直接引用
      
    3. Initializing
      1. 调用类初始化代码 <clinit>，给静态成员变量赋初始值
       
#3. 自定义类加载器
     1. extends ClassLoader
     2. overwrite findClass() -> defineClass(byte[] -> Class clazz)
     3. 加密
     4. 第一节课遗留问题：parent是如何指定的，打破双亲委派
        1. 用super(parent)指定
        2. 双亲委派的打破
           1. 如何打破：重写loadClass（）
           2. 何时打破过？
              1. JDK1.2之前，自定义ClassLoader都必须重写loadClass()
              2. ThreadContextClassLoader可以实现基础类调用实现类代码，通过thread.setContextClassLoader指定
              3. 热启动，热部署
                 1. osgi tomcat 都有自己的模块指定classloader（可以加载同一类库的不同版本）
          ：
#3. 小总结：
    1. load - 默认值 - 初始值
    2. new - 申请内存 - 默认值 - 初始值
