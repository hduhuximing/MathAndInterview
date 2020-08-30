package LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/26 8:28 下午
 * @description 层次遍历
 */
public class leetcode752 {
    public int openLock(String[] deadends, String target) {
//        Set<String> dead = new HashSet<>();
//        for (String deadend : deadends) {
//            dead.add(deadend);
//        }
//        Set<String> visited = new HashSet<>();
//        Queue<String> queue = new LinkedList<>();
//        int res = 0;
//        visited.add("0000");
//        queue.add("0000");
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                String curr = queue.poll();
//                if (dead.contains(curr)) {
//                    continue;
//                }
//                if (curr.equals(target)) {
//                    return res;
//                }
//                for (int j = 0; j < 4; j++) {
//                    String up = plugOne(curr, j);
//                    if (!visited.contains(up)) {
//                        visited.add(up);
//                        queue.offer(up);
//                    }
//                    String down = minusOne(curr, j);
//                    if (!visited.contains(down)) {
//                        visited.add(down);
//                        queue.offer(down);
//                    }
//                }
//            }
//            res++;
//        }
//        return res;
        Set<String> deads = new HashSet<>();
        for (String s : deadends)
            deads.add(s);
        // 用集合不用队列，可以快速判断元素是否存在
        Set<String> q1 = new HashSet<>();
        Set<String> q2 = new HashSet<>();
        Set<String> visited = new HashSet<>();
        int step = 0;
        q1.add("0000");
        q2.add(target);
        while (!q1.isEmpty() && !q2.isEmpty()) {
        // 哈希集合在遍历的过程中不能修改，用 temp 存储扩散结果
            Set<String> temp = new HashSet<>();
            /* 将 q1 中的所有节点向周围扩散 */
            for (String cur : q1) {
                /* 判断是否到达终点 */
                if (deads.contains(cur))
                    continue;
                if (q2.contains(cur))
                    return step;
                visited.add(cur);
                /* 将一个节点的未遍历相邻节点加入集合 */
                for (int j = 0; j < 4; j++) {
                    String up = plugOne(cur, j);
                    if (!visited.contains(up))
                        temp.add(up);
                    String down = minusOne(cur, j);
                    if (!visited.contains(down))
                        temp.add(down);
                    /* 在这里增加步数 */
                }
            }
            step++;
            // temp 相当于 q1
            // 这里交换 q1 q2，下一轮 while 就是扩散 q2
            q1 = q2;
            q2 = temp;
        }
        return -1;
    }

    private String plugOne(String curr, int j) {
        char[] ch = curr.toCharArray();
        if (ch[j] == '9') {
            ch[j] = 0;
        } else {
            ch[j]++;
        }
        return String.valueOf(ch);
    }

    private String minusOne(String curr, int j) {
        char[] ch = curr.toCharArray();
        if (ch[j] == '0') {
            ch[j] = 9;
        } else {
            ch[j]--;
        }
        return String.valueOf(ch);
    }

}
