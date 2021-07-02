package LeetCode;

import java.util.*;

/**
 * @author ming
 * @version 1.0
 * @date 2021/5/20 11:02 下午
 * @description
 */
public class leetcode692 {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> queue = new PriorityQueue<>((o1, o2) -> {
            if (map.get(o1).equals(map.get(o2))) {
                return o2.compareTo(o1);
            }
            return map.get(o1) - map.get(o2);
        });
        for (String s : map.keySet()) {
            queue.offer(s);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        List<String> res = new ArrayList<>();
        while (queue.size() != 0) {
            res.add(queue.poll());
        }
        Collections.reverse(res);
        return res;
    }
}
