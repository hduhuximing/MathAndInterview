package LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author ming
 * @version 1.0
 * @date 2020/2/11 2:02 下午
 * @description
 */
public class leetcode295 {
    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;
    private int count;

    /**
     * initialize your data structure here.
     */
    public leetcode295() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((o1, o2) -> o2.compareTo(o1));
//        minHeap = new PriorityQueue<>(Comparator.reverseOrder());
    }

    //最小栈存最大数，最大栈存小数
    public void addNum(int num) {
        //偶数
        if ((count & 1) == 0) {
            if (!maxHeap.isEmpty() && num < maxHeap.peek()) {
                //最小
                maxHeap.offer(num);
                num = maxHeap.poll();
            }
            //最大
            minHeap.offer(num);
        } else {
            if (!minHeap.isEmpty() && num > minHeap.peek()) {
                minHeap.offer(num);
                num = minHeap.poll();
            }
            maxHeap.offer(num);
        }

        count++;
    }

    public double findMedian() {
        //偶数
        if ((count & 1) == 0) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            //奇数
            return (double) minHeap.peek();
        }
    }

    public static void main(String[] args) {
        leetcode295 le = new leetcode295();
        le.addNum(1);
        le.addNum(2);
        System.out.println(le.findMedian());
        le.addNum(3);
        System.out.println(le.findMedian());
    }
}

