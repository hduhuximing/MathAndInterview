package com.geely.juc;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author m
 * @version 1.0
 * @date 2019/11/14 9:46
 */
public class SynchronousQueueDemo {
//不存储 ，做一个取一个
    public static void main(String[] args) {
        BlockingQueue<String> queue = new SynchronousQueue<>();
        new Thread(() -> {
            try {

                System.out.println("put1");
                queue.put("1");

                System.out.println("put2");
                queue.put("2");

                System.out.println("put3");
                queue.put("3");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "thread1").start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.println(queue.take());
                TimeUnit.SECONDS.sleep(5);
                System.out.println(queue.take());
                TimeUnit.SECONDS.sleep(5);
                System.out.println(queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "thread2").start();
    }
}
