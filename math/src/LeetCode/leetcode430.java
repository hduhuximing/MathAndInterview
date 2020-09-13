package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/22 2:07 下午
 * @description
 */
public class leetcode430 {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    Node pre = null;
    public Node flatten(Node head) {
        if (head == null) {
            return head;
        }
        dfs(head);
        return head;
    }

    private void dfs(Node head) {
        if (head == null) {
            return;
        }
        Node next = head.next;
        if (pre != null) {
            pre.next = head;
            head.prev = pre;
        }
        pre = head;
        dfs(head.child);
        head.child = null;
        dfs(next);
    }
}
