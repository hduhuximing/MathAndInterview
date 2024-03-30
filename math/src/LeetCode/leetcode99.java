package LeetCode;


/**
 * @author ming
 * @version 1.0
 * @date 2020/8/7 1:48 下午
 * @description
 */
public class leetcode99 {
    TreeNode pre = null;
    TreeNode first = null;
    TreeNode second = null;

    public void recoverTree(TreeNode root) {
        helper(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root.left);
        if (pre != null && pre.val > root.val) {
            if (first == null) {
                first = pre;
            }
            second = root;
        }
        pre = root;
        helper(root.right);
    }


    TreeNode pre1 = null;
    TreeNode first1 = null;
    TreeNode second1 = null;

    public void recoverTree1(TreeNode root) {
        helper1(root);
        //交换两个节点
        int temp = first1.val;
        first1.val = second1.val;
        second1.val = temp;
    }

    private void helper1(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root.left);
        //找到前一个大于后一个的位置，一般会出现两次，出现前应该还需要将pre节点赋值。
        if (pre != null && pre.val > root.val) {
            if (first == null) {
                first = pre;
            }
            second = root;
        }
        pre = root;
        helper(root.right);
    }
}
