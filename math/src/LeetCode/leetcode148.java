package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/22 1:24 下午
 * @description
 */
public class leetcode148 {
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return head;
        }
        return help(head);
    }

    private ListNode help(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next!= null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = slow.next;
        slow.next = null;
        head = help(head);
        fast = help(fast);
        return merge(head, fast);
    }

    private ListNode merge(ListNode slow, ListNode fast) {
        if (slow == null) {
            return fast;
        }
        if (fast == null) {
            return slow;
        }
        if (slow.val < fast.val) {
            slow.next = merge(slow.next, fast);
            return slow;
        } else {
            fast.next = merge(slow, fast.next);
            return fast;
        }
    }
}
