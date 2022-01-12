package LeetCode;

import java.util.PriorityQueue;

/**
 * @author ming
 * @version 1.0
 * @date 2022/1/12 10:39 PM
 * @description
 */
public class leetcode703 {
    private PriorityQueue<Integer> queue;
    private int k;

    public leetcode703(int k, int[] nums) {
        this.k = k;
        queue = new PriorityQueue<>(k, (o1, o2) -> o2 - o1);
        for (int i = 0; i < nums.length; i++) {
            add(nums[i]);
        }

    }

    public int add(int val) {
        if (queue.size() < k) {
            queue.offer(val);
        } else if (queue.peek() < val) {
            queue.poll();
            queue.offer(val);
        }
        return queue.peek();

    }
}
