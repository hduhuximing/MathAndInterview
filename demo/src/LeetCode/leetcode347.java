package LeetCode;

import java.util.*;

/**
 * @author ming
 * @version 1.0
 * @date 2020/3/9 6:54 下午
 * @description
 */
public class leetcode347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(((o1, o2) -> map.get(o1) - map.get(o2)));
        for (int num : map.keySet()) {
            queue.add(num);
            if(queue.size()>k){
                queue.poll();
            }
        }
        while(!queue.isEmpty()){
            res.add(queue.poll());
        }
        Collections.reverse(res);
        return res;
    }
}
