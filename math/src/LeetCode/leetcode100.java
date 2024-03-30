package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2022/6/5 11:06 PM
 * @description
 */
public class leetcode100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
