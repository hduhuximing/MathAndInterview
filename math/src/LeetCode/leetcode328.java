package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/18 7:41 下午
 * @description
 */
public class leetcode328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode frist = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = frist;
        return head;
    }
}
