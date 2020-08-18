package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/15 2:06 下午
 * @description
 */
public class leetcode83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null && head.next == null) {
            return head;
        }
        ListNode temp = head;
        while (temp.next != null) {
            if (temp.next.val != temp.val) {
                temp = temp.next;
            } else {
                temp.next = temp.next.next;
            }
        }
        return head;
    }
}
