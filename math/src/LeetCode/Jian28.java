package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/19 3:40 下午
 * @description
 */
public class Jian28 {
    public boolean isSymmetric(TreeNode root) {
        return help(root, root);
    }

    private boolean help(TreeNode root1, TreeNode root2) {
        // 都为空
        if (root1 == null && root2 == null) {
            return true;
        }
        // 其中一个为空 或者数值不相等
        if (root1 == null || root2 == null || root1.val != root2.val) {
            return false;
        }
        return help(root1.left, root2.right) && help(root1.right, root2.left);
    }
}
