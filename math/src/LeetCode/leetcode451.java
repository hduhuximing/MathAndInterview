package LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author ming
 * @version 1.0
 * @date 2020/3/22 11:02 下午
 * @description
 */
public class leetcode451 {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> q = new PriorityQueue<>((o1, o2) -> {
            if (o1.getValue().equals(o2.getValue())) {
                return o1.getKey() - o2.getKey();
            } else {
                return o2.getValue() - o1.getValue();
            }
        });
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            q.offer(entry);
        }
        StringBuilder str=new StringBuilder();
        while(!q.isEmpty()){
            Map.Entry<Character, Integer> poll = q.poll();
            for(int i=0;i<poll.getValue();i++){
                str.append(poll.getKey());
            }
        }
        return str.toString();
    }
}
