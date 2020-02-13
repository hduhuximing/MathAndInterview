package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/2/11 8:04 下午
 * @description
 */
public class leetcode222 {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = countLeft(root.left);
        int right = countLeft(root.right);
        if (left == right) {
            return countNodes(root.right) + 1 << left;
        } else {
            return countNodes(root.left) + 1 << right;
        }
    }

    private int countLeft(TreeNode root) {
        int res = 0;
        while (root != null) {
            res++;
            root = root.left;
        }
        return res;
    }
}
