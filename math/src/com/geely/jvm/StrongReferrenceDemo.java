package com.geely.jvm;

import java.util.WeakHashMap;

/**
 * @author m
 * @version 1.0
 * @date 2019/11/14 9:09
 */
public class StrongReferrenceDemo {
    public static void main(String[] args) {
        Object ob = new Object();
        Object ob1 = ob;
        ob1 = null;
        System.gc();
        System.out.println(ob1);

        WeakHashMap<Integer, String> weakHashMap = new WeakHashMap<>();
        Integer key = new Integer(11);
        String value = "aaaa";
        weakHashMap.put(key, value);
        System.out.println(weakHashMap);
        key=null;
        System.out.println(weakHashMap);
        System.gc();
        System.out.println(weakHashMap+"\t"+weakHashMap.size());
    }
}
