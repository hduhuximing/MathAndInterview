package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/22 12:55 下午
 * @description
 */
public class leetcode143 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode mid = middleNode(head);
        ListNode left = head;
        ListNode right = mid.next;
        mid.next = null;
        right = reverseList(right);
        merge(left, right);
    }

    private void merge(ListNode left, ListNode right) {
        ListNode leftTemp;
        ListNode rightTemp;
        while (left != null && right != null) {
            leftTemp = left.next;
            rightTemp = right.next;
            left.next = right;
            right.next = leftTemp;
            left = leftTemp;
            right = rightTemp;
        }
    }

    private ListNode reverseList(ListNode right) {
        ListNode pre = null;
        ListNode next = null;
        while (right != null) {
            next = right.next;
            right.next = pre;
            pre = right;
            right = next;
        }
        return pre;
    }

    private ListNode middleNode(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast == null && fast.next == null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
