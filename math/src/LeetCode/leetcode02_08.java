package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/9/10 10:33 上午
 * @description
 */
public class leetcode02_08 {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                while (fast != head) {
                    fast = fast.next;
                    head = head.next;
                }
                return head;
            }
        }
        return null;
    }
}
