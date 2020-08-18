package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/17 2:29 下午
 * @description
 */
public class leetcode25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode dumy = new ListNode(0);
        dumy.next = head;
        ListNode pointer = dumy;
        while (pointer != null) {
            ListNode pre = pointer;
            int i = 0;
            for (; i < k; i++) {
                pointer = pointer.next;
                if (pointer == null) {
                    break;
                }
            }
            //如果是提前结束（数量不足k）不用翻转
            if (i == k) {
                ListNode next = pointer.next;
                ListNode rev = reverse(pre.next, next);
                pointer = pre.next;
                pre.next = rev;
                pointer.next = next;
            }
        }
        return dumy.next;
    }

    private ListNode reverse(ListNode head, ListNode tail) {
        if (head == null || head == tail) {
            return head;
        }
        ListNode pre = null;
        ListNode next = null;
        while (head != tail) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
