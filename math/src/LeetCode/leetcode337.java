package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/2/12 2:00 下午
 * @description
 */
public class leetcode337 {
    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] res = help(root);
        return Math.max(res[0], res[1]);
    }

    private int[] help(TreeNode root) {
        //返回条件
        if (root == null) {
            return new int[]{0, 0};
        }
        //从下向上求
        int[] l = help(root.left);
        int[] r = help(root.right);
        int[] res = new int[2];
        //取根节点
        res[0] = root.val + l[1] + r[1];
        //不取根节点
        res[1] = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
        return res;
    }
}
