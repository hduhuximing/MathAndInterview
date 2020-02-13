package LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author ming
 * @version 1.0
 * @date 2020/2/11 2:18 下午
 * @description
 */
public class Solution {
    /**
     * https://sunweiguo.github.io/2019/03/18/%E5%89%91%E6%8C%87offer/%E3%80%90%E9%9D%A2%E8%AF%95%E9%A2%9863-%E6%95%B0%E6%8D%AE%E6%B5%81%E4%B8%AD%E7%9A%84%E4%B8%AD%E4%BD%8D%E6%95%B0%E3%80%91/
     */
    int count;
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(15, new Comparator<Integer>() {
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

    public void Insert(Integer num) {
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

    public Double GetMedian() {
        //偶数
        if ((count & 1) == 0) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            //奇数
            return (double) minHeap.peek();
        }
    }

    public static void main(String[] args) {
        Solution le = new Solution();
        le.Insert(1);
        le.Insert(2);
        System.out.println(le.GetMedian());
        le.Insert(3);
        System.out.println(le.GetMedian());
    }

}