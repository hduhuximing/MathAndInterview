package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/19 3:23 下午
 * @description
 */
public class leetcode572 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        return isSubtree(s.left, t) || isSubtree(s.right, t) || help(s, t);
    }

    private boolean help(TreeNode s, TreeNode t) {
        if (t == null && s == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.val != t.val) {
            return false;
        }
        return help(s.left, t.left) && help(s.right, t.right);
    }
}
