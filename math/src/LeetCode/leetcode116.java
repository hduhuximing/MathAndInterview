package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2021/12/30 10:39 PM
 * @description
 */
public class leetcode116 {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        if (root.left != null) {
            root.left.next = root.right;
            if (root.next != null) {
                root.right.next = root.next.left;
            }
        }
        connect(root.left);
        connect(root.right);
        return root;
    }
}
