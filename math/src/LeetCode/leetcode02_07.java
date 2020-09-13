package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/9/10 10:41 上午
 * @description
 */
public class leetcode02_07 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode A = headA;
        ListNode B = headB;
        while (A != B) {
            A = A == null ? headB : A.next;
            B = B == null ? headA : B.next;
        }
        return A;
    }
}
