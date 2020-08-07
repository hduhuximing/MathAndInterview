package offer;


import java.util.Scanner;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/4 11:39 上午
 * @description
 */
public class PublicResource {
    private static int number = 0;
    private static int max = 0;

    public PublicResource(int num) {
        max = num;
    }

    /**
     * 增加公共资源
     */
    public synchronized void increace() {
        while (number == max) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        number++;
        System.out.println("当前数量" + number);
        notify();
    }

    /**
     * 减少公共资源
     */
    public synchronized void decreace() {
        while (number == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        number--;
        System.out.println("当前数量" + number);
        notify();
    }


    /**
     * 生产者线程，负责生产公共资源
     */
    static class ProducerThread implements Runnable {
        private PublicResource resource;

        public ProducerThread(PublicResource resource) {
            this.resource = resource;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep((long) (Math.random() * 1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                resource.increace();
            }
        }
    }

    /**
     * 消费者线程，负责消费公共资源
     */
    static class ConsumerThread implements Runnable {
        private PublicResource resource;

        public ConsumerThread(PublicResource resource) {
            this.resource = resource;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep((long) (Math.random() * 1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                resource.decreace();
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int max = scanner.nextInt();
        PublicResource resource = new PublicResource(max);
        new Thread(new ProducerThread(resource)).start();
        new Thread(new ProducerThread(resource)).start();
        new Thread(new ProducerThread(resource)).start();
        new Thread(new ConsumerThread(resource)).start();
        new Thread(new ConsumerThread(resource)).start();
        new Thread(new ConsumerThread(resource)).start();
    }
}
