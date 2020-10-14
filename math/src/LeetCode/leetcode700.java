package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/9/14 1:25 下午
 * @description
 */
public class leetcode700 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val > val) {
            return searchBST(root.right, val);
        } else if (root.val < val) {
            return searchBST(root.left, val);
        } else {
            return root;
        }
    }
}
