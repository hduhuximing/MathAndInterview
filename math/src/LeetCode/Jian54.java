package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/20 2:16 下午
 * @description
 */
public class Jian54 {

    int index = 0;
    int res = 0;

    public int kthLargest(TreeNode root, int k) {
        this.index = k;
        f(root);
        return res;
    }

    public void f(TreeNode root) {

        if (root == null) return;
        f(root.right);
        if (--index == 0) res = root.val;
        f(root.left);
    }
}

