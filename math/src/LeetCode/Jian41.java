package LeetCode;


import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/20 11:06 上午
 * @description
 */
public class Jian41 {
    Queue<Integer> A;//多
    Queue<Integer> B;//少

    public Jian41() {
        A = new PriorityQueue<>(); // 小顶堆，保存较大的一半
        B = new PriorityQueue<>((x, y) -> (y - x)); // 大顶堆，保存较小的一半
    }

    public void addNum(int num) {
        if (A.size() != B.size()) {
            A.add(num);
            B.add(A.poll());
        } else {
            B.add(num);
            A.add(B.poll());
        }
    }

    public double findMedian() {
        return A.size() != B.size() ? A.peek() : (A.peek() + B.peek()) / 2.0;
    }

}
