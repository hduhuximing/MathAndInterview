package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/7/22 7:25 下午
 * @description
 */
public class leetcode114 {
    public void flatten(TreeNode root) {
        while (root != null) {
            if (root.left == null) {
                root = root.right;
            } else {
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = root.right;
                root.right = root.left;
                root.left = null;
                root=root.right;
            }
        }
    }
}
