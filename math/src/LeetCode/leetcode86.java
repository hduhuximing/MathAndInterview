package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/17 7:20 下午
 * @description
 */
public class leetcode86 {
    public ListNode partition(ListNode head, int x) {
        ListNode pre = new ListNode(0);
        ListNode resPre = pre;
        ListNode last = new ListNode(0);
        ListNode currLast = last;
        while (head != null) {
            if (head.val < x) {
                pre.next = head;
                pre = pre.next;
            } else {
                last.next = head;
                last = last.next;
            }
            head = head.next;
        }
        last.next = null;
        pre.next = currLast.next;
        return resPre.next;
    }
}
