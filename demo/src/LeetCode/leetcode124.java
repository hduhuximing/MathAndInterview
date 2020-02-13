package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/2/11 6:16 下午
 * @description
 */
public class leetcode124 {
    private int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        help(root);
        return res;
    }

    private int help(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0, help(root.left));
        int right = Math.max(0, help(root.right));
        res=Math.max(res,left+right+root.val);
        return Math.max(left,right)+root.val;
    }
}
