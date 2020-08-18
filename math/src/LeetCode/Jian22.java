package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/18 12:04 下午
 * @description
 */
public class Jian22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode pre = head;
        int i = 0;
        while (i < k) {
            if (pre.next == null) {
                return head.next;
            }
            pre = pre.next;
            i++;
        }
        while (pre != null) {
            pre = pre.next;
            head = head.next;
        }
        return head;
    }
}
