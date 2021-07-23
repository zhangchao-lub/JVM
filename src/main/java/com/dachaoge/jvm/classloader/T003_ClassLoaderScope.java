package com.dachaoge.jvm.classloader;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2021/6/11 10:16
 * @descrption 一、加载过程
 * 1，Loading
 * 1、顶级ClassLoader（底层由C++实现）返回null
 * 2、为什么要使用双亲委派：1）安全问题（主要）
 * 2）重复加载
 */
public class T003_ClassLoaderScope {
    public static void main(String[] args) {
        String pathBoot = System.getProperty("sun.boot.class.path");
        System.out.println(pathBoot.replaceAll(";", System.lineSeparator()));

        System.out.println("---------------");
        String pathExt = System.getProperty("java.ext.dirs");
        System.out.println(pathExt.replaceAll(";", System.lineSeparator()));

        System.out.println("---------------");
        String pathApp=System.getProperty("java.class.path");
        System.out.println(pathApp.replaceAll(";",System.lineSeparator()));
    }
}
