package com.geely.juc;

import java.util.concurrent.atomic.AtomicInteger;

public class CASDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger=new AtomicInteger();
        int i = atomicInteger.get();
        System.out.println(i);
        atomicInteger.getAndIncrement();
        System.out.println(atomicInteger.get());
    }
}
