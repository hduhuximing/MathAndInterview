package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2022/1/10 10:59 PM
 * @description
 */
public class leetcode993 {
    public int deepNode(TreeNode root, int n, int deep) {
        if (root == null) {
            return -1;
        }
        if (root.val == n) {
            return deep;
        }
        int left = deepNode(root.left, n, deep + 1);
        int right = deepNode(root.right, n, deep + 1);
        return left == -1 ? right : left;
    }

    public boolean fatherNodeVal(TreeNode root, int x, int y) {
        if (root == null) {
            return true;
        }
        if (root.left != null && root.right != null) {
            if ((root.left.val == x && root.right.val == y) || (root.left.val == y && root.right.val == x)) {
                return false;
            }
        }
        return fatherNodeVal(root.left, x, y) && fatherNodeVal(root.right, x, y);
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        return deepNode(root, x, 0) == deepNode(root, y, 0) && fatherNodeVal(root, x, y);
    }
}
