package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/18 9:02 下午
 * @description
 */
public class leetcode18 {
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        ListNode dumy = new ListNode(0);
        dumy.next = head;
        ListNode pre = dumy;
        while (head != null) {
            while (head.val == val) {
                head = head.next;
            }

            pre.next = head;
            pre = pre.next;
            if (head != null) {
                head = head.next;
            }
//            pre = head;
//            head = head.next;
        }
        return dumy.next;
    }
}
