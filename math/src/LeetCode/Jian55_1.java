package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/20 2:33 下午
 * @description
 */
public class Jian55_1 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}
