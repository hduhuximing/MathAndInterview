package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/9/10 10:52 上午
 * @description
 */
public class leetcode02_01 {
    public ListNode removeDuplicateNodes(ListNode head) {
        ListNode res = head;
        while (res != null) {
            ListNode temp = res;
            while (temp.next != null) {
                if (temp.next.val == temp.val) {
                    temp.next = temp.next.next;
                } else {
                    temp = temp.next;
                }
            }
            res = res.next;
        }
        return head;
    }
}
