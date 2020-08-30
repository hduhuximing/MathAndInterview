package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/15 2:19 下午
 * @description
 */
public class leetcode110 {
    public boolean isBalanced(TreeNode root) {
        return help(root) >= 0;
    }

    private int help(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = help(root.left);
        int r = help(root.right);
        if (l == -1 || r == -1 || Math.abs(l - r) > 1) {
            return -1;
        }
        return Math.max(l, r) + 1;
    }
}
