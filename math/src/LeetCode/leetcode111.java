package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/15 2:23 下午
 * @description
 */
public class leetcode111 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = minDepth(root.left);
        int r = minDepth(root.right);
        if (l == 0 || r == 0) {
            return l + r + 1;
        }
        return Math.min(l, r) + 1;
    }
}
