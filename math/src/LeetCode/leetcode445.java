package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/15 12:28 下午
 * @description
 */
public class leetcode445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode re1 = reverse(l1);
        ListNode re2 = reverse(l2);
        ListNode curr = new ListNode(-1);
        ListNode pre = null;
        ListNode res = null;
        int carry = 0;
        while (re1 != null || re2 != null) {
            int num1 = re1 == null ? 0 : re1.val;
            int num2 = re2 == null ? 0 : re2.val;
            carry += num1 + num2;
            pre = res;
            res = new ListNode(carry % 10);
            carry /= 10;
            curr.next = pre;
            re1 = re1 != null ? re1.next : null;
            re2 = re2 != null ? re2.next : null;
        }
        if (carry == 1) {
            pre = res;
            res = new ListNode(1);
            res.next = pre;
        }
        return res;

    }

    private ListNode reverse(ListNode root) {
        ListNode pre = null;
        ListNode next = null;
        while (root != null) {
            next = root.next;
            root.next = pre;
            pre = root;
            root = next;
        }
        return pre;
    }
}
