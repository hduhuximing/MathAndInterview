package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/17 4:44 下午
 * @description
 */
public class leetcode82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode pre = res;
        while (head != null && head.next != null) {
            if (head.val != head.next.val) {
                pre = head;
                head = head.next;
            } else {
                while (head != null && head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                pre.next = head.next;
                head = head.next;
            }
        }
        return res.next;
    }
}