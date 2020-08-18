package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/18 9:45 下午
 * @description
 */
public class Jian24 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
