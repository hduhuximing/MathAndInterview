package com.geely.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author m
 * @version 1.0
 * @date 2019/11/14 14:46
 */
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        String name = MyThread.name;
        System.out.println(name);
//        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread2());
//        new Thread(futureTask, "aaa").start();
//        int b=0;
//        while (futureTask.isDone()) {
//            b = futureTask.get();
//        }
//        System.out.println(b);
    }
}

class MyThread implements Runnable {
    public static String name="xiaiming";
    static{
        System.out.println("静态代码块初始化");
    }
    public MyThread(){
        System.out.println("构造函数初始化了");
    }
    @Override
    public void run() {
    }
}

class MyThread2 implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("Callable come in");
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 1024;
    }
}

