package LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/21 9:55 上午
 * @description
 */
public class leetcode817 {
    public int numComponents(ListNode head, int[] G) {
        Set<Integer> set = new HashSet<>();
        for (int i : G) {
            set.add(i);
        }
        int res = 0;
        while (head != null) {
            if (set.contains(head.val) && (head.next == null || !set.contains(head.next.val))) {
                res++;
            }
            head = head.next;
        }
        return res;
    }
}
