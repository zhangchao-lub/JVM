package com.dachaoge.jvm.classloader;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2021/6/11 10:16
 * @descrption 一、加载过程
 *              1，Loading
 *                  1、顶级ClassLoader（底层由C++实现）返回null
 *                  2、为什么要使用双亲委派：1）安全问题（主要）
 *                                           2）重复加载
 */
public class T005_LoadClassByHand {
    public static void main(String[] args) throws ClassNotFoundException {
        Class clazz=T005_LoadClassByHand.class.getClassLoader().loadClass("com.dachaoge.jvm.classloader.T002_ClassLoaderLevel");
        System.out.println("name:"+clazz.getName());

//        利用类加载器加载资源，参考坦克图片的加载
//        T005_LoadClassByHand.class.getClassLoader().getResourceAsStream("");
    }
}
