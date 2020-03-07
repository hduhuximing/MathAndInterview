package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/3/6 10:25 上午
 * @description
 */

public class leetcode2 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dum = new ListNode(-1);
        ListNode curr = dum;
        int sum = 0;
        while (l1 != null || l2 != null) {
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;
            sum += x + y;
            curr.next = new ListNode(sum % 10);
            sum /= 10;
            curr = curr.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (l1 != null) {
            curr.next = l2;
        }
        if (l2 != null) {
            curr.next = l1;
        }
        if (sum == 1) {
            curr.next = new ListNode(1);
        }
        return dum.next;
    }
}
