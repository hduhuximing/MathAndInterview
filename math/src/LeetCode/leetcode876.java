package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2021/12/28 10:46 PM
 * @description
 */
public class leetcode876 {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
