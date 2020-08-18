package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/17 2:58 下午
 * @description
 */
public class leetcode98 {
    public boolean isValidBST(TreeNode root) {
        return help(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean help(TreeNode root, long minValue, long maxValue) {
        if (root == null) {
            return true;
        }
        if (root.val <= minValue || root.val >= maxValue) {
            return false;
        }
        return help(root.left, minValue, root.val)
                && help(root.right, root.val, maxValue);
    }
}
