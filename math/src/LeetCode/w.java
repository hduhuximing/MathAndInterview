package LeetCode;


/**
 * @author ming
 * @version 1.0
 * @date 2020/8/24 3:58 下午
 * @description
 */
public class w implements Runnable {

    int x = 0;

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            x=x+1;
            System.out.println(Thread.currentThread()+"——————》》》"+x);
        }
    }

    public static void main(String[] args) {
        w w1 = new w();
        new Thread(w1).start();
        new Thread(w1).start();
        System.out.println(w1.x);
    }
}
