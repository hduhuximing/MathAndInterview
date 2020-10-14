package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/9/14 1:06 下午
 * @description
 */
public class leetcode606 {
    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        if (t.left == null && t.right == null) {
            return t.val + "";
        }
        if (t.right == null) {
            return t.val + "(" + tree2str(t.left) + ")";
        }
        return t.val + "(" + tree2str(t.left) + ")(" + tree2str(t.right) + ")";
    }
}
