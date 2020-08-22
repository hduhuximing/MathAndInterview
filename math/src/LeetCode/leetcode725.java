package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/22 2:24 下午
 * @description
 */
public class leetcode725 {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode curr = root;
        int N = 0;
        while (curr != null) {
            curr = curr.next;
            N++;
        }
        int width = N / k;
        int rem = N % k;
        curr = root;
        ListNode[] res = new ListNode[k];
        for (int i = 0; i < k; i++) {
            ListNode head = curr;
            for (int j = 0; j < width - 1 + (i < rem ? 1 : 0); j++) {
                if (curr != null) {
                    curr = curr.next;
                }
            }
            if (curr != null) {
                ListNode pre = curr;
                curr = curr.next;
                pre.next = null;
            }
            res[i] = head;
        }
        return res;
    }
}
