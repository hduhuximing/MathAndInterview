package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/2 10:15 下午
 * @description
 */
public class leetcode226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
