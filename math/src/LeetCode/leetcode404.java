package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/19 10:18 上午
 * @description
 */
public class leetcode404 {
    private int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return sum;
        }
        help(root);
        return sum;
    }

    private void help(TreeNode root) {
        if (root == null) {
            return;
        }
        if (isLeft(root.left)) {
            sum += root.left.val;
        }
        help(root.left);
        help(root.right);
    }

    private boolean isLeft(TreeNode root) {
        return root != null && root.left == null && root.right == null;
    }
}
