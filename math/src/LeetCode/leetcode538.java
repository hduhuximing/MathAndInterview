package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/2/12 8:13 下午
 * @description
 */
public class leetcode538 {
    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        help(root);
        return root;
    }

    private void help(TreeNode root) {
        if (root == null) {
            return ;
        }
        //向右边
        help(root.right);
        //更新一下当前节点
        root.val += sum;
        //获取最大值
        sum = root.val;
        //最大值作为起始位置，更新左侧，
        help(root.left);
    }
}
