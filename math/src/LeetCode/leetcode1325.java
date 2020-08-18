package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/18 12:30 下午
 * @description
 */
public class leetcode1325 {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) {
            return root;
        }
        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);
        if (root.val == target && root.left == null && root.right == null) {
            return null;
        }
        return root;
    }
}
