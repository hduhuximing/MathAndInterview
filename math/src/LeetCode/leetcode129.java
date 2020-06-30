package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/2/11 6:36 下午
 * @description
 */
public class leetcode129 {
    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    private int res = 0;
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        help(root,0);
        return res;
    }

    private void help(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        sum+=root.val;
        if (root.left == null && root.right == null) {
            res += sum;
        }
        help(root.left, sum * 10);
        help(root.right, sum * 10);
    }
}