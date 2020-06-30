package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/2/12 8:47 下午
 * @description 给定二叉搜索树:
 * <p>
 * 4
 * / \
 * 2   7
 * / \
 * 1   3
 * <p>
 * 和 插入的值: 5
 * 你可以返回这个二叉搜索树:
 * <p>
 * 4
 * /   \
 * 2     7
 * / \   /
 * 1   3 5
 */
public class leetcode701 {
    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public TreeNode insertIntoBST(TreeNode root, int val) {
        //root为当前位置，如果是空的就可以插入，否则需要向下继续遍历
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        }
        if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }
}
