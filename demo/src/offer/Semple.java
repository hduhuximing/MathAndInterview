package offer;

import java.util.concurrent.Semaphore;

/**
 * @author ming
 * @version 1.0
 * @date 2020/3/30 4:24 下午
 * @description
 */
public class Semple {
    static class Conditonextends extends Thread {
        private Semaphore preCond;
        private Semaphore postCond;

        public Conditonextends(Semaphore preCond, Semaphore postCond, String name) {
            this.preCond = preCond;
            this.postCond = postCond;
            this.setName(name);
        }

        @Override
        public void run() {
            try {
                preCond.acquire();
                System.out.println(Thread.currentThread().getName());
                postCond.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    static class ConditionThread extends Thread {
        private Semaphore preCond;
        private Semaphore postCond;

        ConditionThread(Semaphore preCond, Semaphore postCond, String name) {
            this.preCond = preCond;
            this.postCond = postCond;
            this.setName(name);
        }

        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    preCond.acquire();
                    System.out.print(Thread.currentThread().getName());
                    postCond.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphoreA = new Semaphore(0);
        Semaphore semaphoreB = new Semaphore(0);
        Semaphore semaphoreC = new Semaphore(1);

        Thread threadA = new ConditionThread(semaphoreC, semaphoreA, "A");
        Thread threadB = new ConditionThread(semaphoreA, semaphoreB, "B");
        Thread threadC = new ConditionThread(semaphoreB, semaphoreC, "C");

        threadA.start();
        threadB.start();
        threadC.start();

    }
}
