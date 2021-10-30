package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/18 12:04 下午
 * @description
 */
public class Jian22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode pre = head;
        int i = 0;
        // 先走k步
        while (i < k) {
            // 如果下一个是空的，直接返回首位
            if (pre.next == null) {
                return head;
            }
            pre = pre.next;
            i++;
        }
        // pre走到空
        while (pre != null) {
            pre = pre.next;
            head = head.next;
        }
        return head;
    }
}
