package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/9 1:18 下午
 * @description
 */
public class leetcode109 {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        return help(head, null);
    }

    private TreeNode help(ListNode head, ListNode tail) {
        if (head == tail) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != tail && fast.next.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = help(head, slow);
        root.right = help(slow.next, tail);
        return root;
    }
}
