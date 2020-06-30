package com.zijie;

/**
 * @author ming
 * @version 1.0
 * @date 2020/3/11 2:00 下午
 * @description
 */
public class ReadWriteDemo {
    private volatile int read;
    private volatile int write;

    public ReadWriteDemo() {
        this.read = 0;
        this.write = 0;
    }

    public synchronized void readLock() throws InterruptedException {
        if (write > 0) {
            wait();
        }
        read++;
    }

    public synchronized void readUnLock() {
        read--;
        notifyAll();
    }

    public synchronized void writeLock() throws InterruptedException {
        if (read > 0 || write > 0) {
            wait();
        }
        write++;
    }

    public synchronized void writeUnLock() {
        write--;
        notifyAll();
    }
}
