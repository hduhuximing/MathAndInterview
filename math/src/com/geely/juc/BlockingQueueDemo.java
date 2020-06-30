package com.geely.juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author m
 * @version 1.0
 * @date 2019/11/14 9:09
 */
public class BlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
       //看文档
        BlockingQueue<String> b=new ArrayBlockingQueue<>(4);
        b.add("a");
        b.add("b");
        b.add("c");
        b.add("b");
        System.out.println(b.offer("d",2L, TimeUnit.SECONDS));
    }
}
