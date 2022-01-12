package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2022/1/2 11:10 AM
 * @description
 */
public class leetcode671 {
    private int res = -1;

    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return res;
        }
        help(root, root.val);
        return res;
    }

    public void help(TreeNode root, int val) {
        if (root == null) {
            return;
        }
        //找到了就返回，根节点一定是整棵树的最小节点
        if (root.val != val) {
            if (res == -1) {
                res = root.val;
            } else {
                res = Math.min(res, root.val);
            }
            return;
        }
        help(root.left, val);
        help(root.right, val);
    }
}
