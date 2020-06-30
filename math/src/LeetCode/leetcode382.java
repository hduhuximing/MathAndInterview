package LeetCode;

import java.util.Random;

/**
 * @author ming
 * @version 1.0
 * @date 2020/5/22 11:51 上午
 * @description 蓄水池
 */
public class leetcode382 {
    /**
     * @param head The linked list's head.
     * Note that the head is guaranteed to be not null, so it contains at least one node.
     */
    ListNode root;
    Random rm = new Random();

    public leetcode382(ListNode head) {
        this.root = head;
    }

    /**
     * Returns a random node's value.
     */
    public int getRandom() {
        int[] res = {-1};
        ListNode head = root;
        //池子当前的水
        int count = 0;
        boolean isFull = false;
        while (head != null) {
            count++;
            if (!isFull) {
                res[0] = head.val;
                isFull = true;
            } else {
                int i = rm.nextInt(count);
                if (i < 1) {
                    res[i] = head.val;
                }
            }
            head = head.next;
        }
        return res[0];
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
