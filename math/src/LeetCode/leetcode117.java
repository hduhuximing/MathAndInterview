package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/9 1:51 下午
 * @description
 */
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

public class leetcode117 {
    public Node connect(Node root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }
        if (root.left != null && root.right != null) {
            root.left.next = root.right;
            root.right.next = help(root);
        }
        if (root.left == null) {
            root.right.next = help(root);
        }
        if (root.right == null) {
            root.left.next = help(root);
        }
        connect(root.right);
        connect(root.left);
        return root;
    }

    private Node help(Node root) {
        if (root == null) {
            return null;
        }
        while (root.next != null) {
            if (root.next.left != null) {
                return root.next.left;
            }
            if (root.next.right != null) {
                return root.next.right;
            }
            root = root.next;
        }
        return null;
    }
}
