package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/7/5 8:22 下午
 * @description
 */
public class leetcode206 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = null;
        ListNode pre = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head = next;
            pre = head;
        }
        return pre;
    }
}
