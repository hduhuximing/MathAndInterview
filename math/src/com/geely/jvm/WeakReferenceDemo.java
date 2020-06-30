package com.geely.jvm;


import java.lang.ref.WeakReference;

/**
 * @author ming
 * @version 1.0
 * @date 2019/11/21 11:48 上午
 */
public class WeakReferenceDemo {




    public static void main(String[] args) {
        Object o1 = new Object();
        WeakReference<Object> weak = new WeakReference<>(o1);
        System.out.println(o1);
        System.out.println(weak);
        o1=null;
        System.gc();
        System.out.println("=========");
        System.out.println(o1);
        System.out.println(weak.get());
    }
}

