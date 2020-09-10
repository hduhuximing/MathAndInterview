package offer;

/**
 * @author ming
 * @version 1.0
 * @date 2020/9/8 9:57 上午
 * @description
 */
public class shunxuProcess {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Work(null), "线程t1");
        Thread t2 = new Thread(new Work(t1), "线程t2");
        Thread t3 = new Thread(new Work(t2), "线程t3");

        t1.start();
        t2.start();
        t3.start();
    }

    static class Work implements Runnable {
        private Thread beforeThread;

        public Work(Thread beforeThread) {
            this.beforeThread = beforeThread;
        }

        @Override
        public void run() {
            if (beforeThread != null) {
                try {
                    //某线程调用该方法，会让其他线程处于等待状态，让其运行完毕，再执行其他线程.
                    beforeThread.join();
                    System.out.println("Thread start:" + Thread.currentThread().getName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Thread start:" + Thread.currentThread().getName());
            }

        }
    }


}
