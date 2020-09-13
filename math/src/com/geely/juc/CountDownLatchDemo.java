package com.geely.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchDemo {
    public static void main(String[] args) {
//        general();
        try {
            countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void general() {
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t上完自习，离开教室");
            }, "Thread-->" + i).start();
        }
        while (Thread.activeCount() > 2) {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "\t=====班长最后关门走人");
    }

    public static void countDown() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <= 7; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t上完自习，离开教室");
                countDownLatch.countDown();
            }, CountryEnum.getEnum(i).getCountry()).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + "\t=====班长最后关门走人");
    }
}
