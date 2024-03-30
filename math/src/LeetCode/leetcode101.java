package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2022/6/7 10:50 PM
 * @description
 */
public class leetcode101 {
    public boolean isSymmetric(TreeNode root) {
        StringBuilder str = new StringBuilder();
        return isValid(root, root);
    }

    //借助辅助方法，首先传入两个节点，
    //如果都是空返回true，只要有一个非空，返回false
    //最终条件，传入的两个节点值相等，向下找，第一个节点的左边，第二个节点的右侧，和第一个节点的右侧，第二个节点的左边
    public boolean isValid(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return isValid(root1.left, root2.right) && isValid(root1.right, root2.left);
    }
}
