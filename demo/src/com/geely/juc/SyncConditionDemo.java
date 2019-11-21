package com.geely.juc;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author m
 * @version 1.0
 * @date 2019/11/14 10:38
 */
public class SyncConditionDemo {
    /**
     * synchronized和lock区别
     * <p===lock可绑定多个条件===
     * 对线程之间按顺序调用，实现A>B>C三个线程启动，要求如下：
     * AA打印5次，BB打印10次，CC打印15次
     * 紧接着
     * AA打印5次，BB打印10次，CC打印15次
     * 。。。。
     * 来十轮
     */
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
//        ShareData shareData = new ShareData();
//
//        new Thread(() -> {
//            for (int i = 1; i <= 10; i++) {
//                shareData.print5();
//            }
//        }, "A").start();
//
//        new Thread(() -> {
//            for (int i = 1; i <= 10; i++) {
//                shareData.print10();
//            }
//        }, "B").start();
//
//        new Thread(() -> {
//            for (int i = 1; i <= 10; i++) {
//                shareData.print15();
//            }
//        }, "C").start();
//    }
}

class ShareData {
    private int number = 1;
    Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();

    public void print5() {
        lock.lock();
        try {
            while (number != 1) {
                condition1.await();
            }
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            number = 2;
            condition2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print10() {
        lock.lock();
        try {
            //判断
            while (number != 2) {
                condition2.await();
            }
            //干活
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            //通知
            number = 3;
            condition3.signal();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print15() {
        lock.lock();
        try {
            //判断
            while (number != 3) {
                condition3.await();
            }
            //干活
            for (int i = 1; i <= 15; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            //通知
            number = 1;
            condition1.signal();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
