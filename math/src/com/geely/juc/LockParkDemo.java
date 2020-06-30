package com.geely.juc;

import java.util.concurrent.locks.LockSupport;

/**
 * @author ming
 * @version 1.0
 * @date 2020/4/19 5:11 下午
 * @description
 */
public class LockParkDemo {
    public static void main(String[] args) {
        //直接返回
        System.out.println("start");
        LockSupport.unpark(Thread.currentThread());
        LockSupport.park();
        System.out.println("end");
    }
}
