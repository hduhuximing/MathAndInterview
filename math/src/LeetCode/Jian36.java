package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/17 2:40 下午
 * @description
 */
public class Jian36 {
    //动
    Node pre = null;
    //首节点
    Node head = null;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return root;
        }
        help(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    private void help(Node root) {
        if (root == null) {
            return;
        }
        help(root.left);
        if (pre == null) {
            pre = head = root;
        } else {
            pre.right = root;
            root.left = pre;
            pre = root;
        }
        help(root.right);
    }
}
