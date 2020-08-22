package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/22 1:14 下午
 * @description
 */
public class Leetcode147 {
    public ListNode insertionSortList(ListNode head) {
        ListNode dumy = new ListNode(0);
        dumy.next = head;
        while (head != null && head.next != null) {
            if (head.val < head.next.val) {
                head = head.next;
            }
            ListNode pre = dumy;
            ListNode curr = head.next;
            while (pre.next.val < curr.val) {
                pre = pre.next;
            }
            head.next = curr.next;
            curr.next = pre.next;
            pre.next = curr;
        }
        return dumy.next;
    }
}
