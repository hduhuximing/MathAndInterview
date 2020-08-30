package offer;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/14 10:30 上午
 * @description 阻塞队列的生产者消费者
 */
class Producer implements Runnable {
    private final BlockingQueue<Integer> queue;

    public Producer(BlockingQueue q) {
        this.queue = q;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(1000);//模拟耗时
                queue.put(produce());
            }
        } catch (InterruptedException e) {
        }
    }

    private int produce() {
        int n = new Random().nextInt(10000);
        System.out.println("Thread:" + Thread.currentThread().getName() + " produce:" + n);
        return n;
    }
}


//消费者
class Consumer implements Runnable {
    private final BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue q) {
        this.queue = q;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(2000);//模拟耗时
                consume(queue.take());
            } catch (InterruptedException e) {
            }
        }
    }
    private void consume(Integer n) {
        System.out.println("Thread:" + Thread.currentThread().getName() + " consume:" + n);
    }
}


public class producerWithconsumer {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(100);
        Producer p = new Producer(queue);
        Consumer c1 = new Consumer(queue);
        Consumer c2 = new Consumer(queue);
        new Thread(p, "producer").start();
        new Thread(c1, "consumer1").start();
        new Thread(c2, "consumer2").start();
    }

}
