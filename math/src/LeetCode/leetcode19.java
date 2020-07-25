package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/7/8 11:04 下午
 * @description
 */
public class leetcode19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = head;
        ListNode after = head;
        while (n != 0) {
            after = after.next;
            n--;
        }
        if (after != null) {
            while (after.next != null) {
                after = after.next;
                pre = pre.next;
            }
            pre.next=pre.next.next;
        } else {
            head = head.next;
        }
        return head;
    }
}
