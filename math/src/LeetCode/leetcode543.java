package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/3/5 4:00 下午
 * @description
 */
public class leetcode543 {
    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        help(root);
        return max;
    }

    private int help(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = help(root.left);
        int right = help(root.right);
        max = Math.max(left + right, max);
        return Math.max(left, right) + 1;
    }

}