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
public class T004_ParentAndChild {
    public static void main(String[] args) {
        System.out.println(T004_ParentAndChild.class.getClassLoader());
        System.out.println(T004_ParentAndChild.class.getClassLoader().getClass().getClassLoader());
        System.out.println(T004_ParentAndChild.class.getClassLoader().getParent());
        System.out.println(T004_ParentAndChild.class.getClassLoader().getParent().getParent());
    }
}
