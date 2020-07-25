package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/7/7 8:32 下午
 * @description
 */
public class leetcode112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        sum -= root.val;
        if (sum == 0 && root.left == null && root.right == null) {
            return true;
        }
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }
}
