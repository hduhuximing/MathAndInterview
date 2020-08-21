package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/20 2:34 下午
 * @description
 */
public class Jian55_2 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return help(root) >= 0;
    }

    private int help(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = help(root.left);
        int right = help(root.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}
