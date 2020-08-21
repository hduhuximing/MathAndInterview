package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/19 3:16 下午
 * @description
 */
public class leetcode563 {
    private int res = 0;

    public int findTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        help(root);
        return res;
    }

    private int help(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = help(root.left);
        int right = help(root.right);
        res += Math.abs(left - right);
        return left + right + root.val;
    }

}
