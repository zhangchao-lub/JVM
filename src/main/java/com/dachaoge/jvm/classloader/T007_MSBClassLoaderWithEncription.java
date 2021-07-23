package com.dachaoge.jvm.classloader;

import com.dachaoge.jvm.Hello;

import java.io.*;

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
public class T007_MSBClassLoaderWithEncription extends ClassLoader {

    public static int seed = 0B10110110;

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        File file = new File("d:/test/", name.replaceAll(".", "/").concat(".msbclass"));
        try {
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int b = 0;

            while ((b = fis.read()) != 0) {
                baos.write(b ^ seed);
            }

            byte[] bytes = baos.toByteArray();
            baos.close();
            fis.close();

            return defineClass(name, bytes, 0, bytes.length);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.findClass(name);
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException {

        encFile("com.dachaoge.jvm.Hello");

        ClassLoader loader = new T007_MSBClassLoaderWithEncription();
        Class clazz = loader.loadClass("com.dachaoge.jvm.Hello");

        Hello h = (Hello) clazz.newInstance();
        h.say();

        System.out.println(loader.getClass().getClassLoader());
        System.out.println(loader.getParent());
    }

    private static void encFile(String name) throws IOException {
        File file = new File("d:/test/", name.replace(".", "/").concat(".class"));
        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream(new File("d:/test/", name.replaceAll(".", "/").concat(".msbclass")));
        int b = 0;

        while ((b = fis.read()) != -1) {
            fos.write(b ^ seed);
        }

        fis.close();
        fos.close();
    }
}
