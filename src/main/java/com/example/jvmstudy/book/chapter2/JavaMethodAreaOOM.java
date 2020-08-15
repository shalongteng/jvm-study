//package com.example.jvmstudy.book.chapter2;
//
//import net.sf.cglib.proxy.Enhancer;
//import net.sf.cglib.proxy.MethodInterceptor;
//import net.sf.cglib.proxy.MethodProxy;
//
//import java.lang.reflect.Method;
//
///**
// * VM Args： -XX:PermSize=10M -XX:MaxPermSize=10M
// * -XX：MaxMetaspaceSize：设置元空间最大值，默认是-1，即不限制，或者说只受限于本地内存大小。
// *
// * @author zzm
// */
//public class JavaMethodAreaOOM {
//
//    public static void main(String[] args) {
//        while (true) {
//            Enhancer enhancer = new Enhancer();
//            enhancer.setSuperclass(OOMObject.class);
//            enhancer.setUseCache(false);
//            enhancer.setCallback(new MethodInterceptor() {
//                public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
//                    return proxy.invokeSuper(obj, args);
//                }
//            });
//            enhancer.create();
//        }
//    }
//
//    static class OOMObject {
//    }
//}
