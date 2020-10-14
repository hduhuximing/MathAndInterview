package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/9/14 1:27 下午
 * @description
 */
public class leetcode783 {
    private int min = Integer.MAX_VALUE;
    private TreeNode pre = null;

    public int minDiffInBST(TreeNode root) {
        if (root == null) {
            return -1;
        }
        help(root);
        return min;
    }

    private void help(TreeNode root) {
        if (root == null) {
            return;
        }
        help(root.left);
        if (pre != null) {
            min = Math.min(min, root.val - pre.val);
        }
        pre = root;
        help(root.right);
    }

}
