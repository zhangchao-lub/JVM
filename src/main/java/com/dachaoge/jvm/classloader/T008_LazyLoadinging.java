package com.dachaoge.jvm.classloader;

import com.dachaoge.jvm.Hello;

import java.io.*;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2021/6/11 10:16
 * @descrption 懒加载
 * 严格意义上应该叫lazy initialing 因为java虚拟机并没有严格规定什么时候必需loading
 */
public class T008_LazyLoadinging extends ClassLoader {
    public static void main(String[] args) throws ClassNotFoundException {
//        P p;
//        X x = new X();
//        System.out.println(P.i);
//        System.out.println(P.j);
        Class.forName("com.dachaoge.jvm.classloader.T008_LazyLoadinging$P");
    }

    public static class P {
        final static int i = 8;
        static int j = 9;

        static {
            System.out.println("P");
        }
    }

    public static class X extends P {
        static {
            System.out.println("X");
        }
    }
}
