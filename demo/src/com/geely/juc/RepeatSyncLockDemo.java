package com.geely.juc;
//可重入锁Sync
public class RepeatSyncLockDemo {
    public static void main(String[] args) {
        Phone phone=new Phone();
        new Thread(()->{
            try {
                phone.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"thread 1").start();
        new Thread(()->{
            try {
                phone.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"thread 2").start();
    }
}

class Phone {
    public synchronized void sendSMS() throws Exception {
        System.out.println(Thread.currentThread().getName() + "\t -----invoked sendSMS()");
        Thread.sleep(3000);
        sendEmail();
    }

    public synchronized void sendEmail() throws Exception {
        System.out.println(Thread.currentThread().getName() + "\t +++++invoked sendEmail()");
    }
}
