package LeetCode;

import java.util.*;

/**
 * @author ming
 * @version 1.0
 * @date 2020/9/6 1:53 下午
 * @description
 */
public class leetcode992 {


    public List<Integer> help(List<Integer> list) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < list.size(); i++) {
            if (queue.size() < 5) {
                queue.add(list.get(i));
            } else {
                if (queue.peek() < list.get(i)) {
                    queue.poll();
                    queue.add(list.get(i));
                }
            }
        }
        return new ArrayList<>(queue);

    }


    public int subarraysWithKDistinct(int[] A, int K) {
        //恰好为 K 可以变为  最多 为 k 个 减去 最多为k - 1个
        return subarraysWithMostK(A, K) - subarraysWithMostK(A, K - 1);
    }

    private int subarraysWithMostK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int res = 0;
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            if (map.get(nums[right]) == 1) {
                count++;
            }
            right++;
            while (count > k) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    count--;
                }
                left++;
            }
            //连续的数组
            res += right - left + 1;
        }
        return res;
    }
}
