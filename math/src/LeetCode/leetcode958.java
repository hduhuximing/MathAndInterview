package LeetCode;

import java.util.LinkedList;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/18 12:43 下午
 * @description 层次遍历+截断
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class leetcode958 {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode remove = queue.remove();
            if (remove == null) {
                while (!queue.isEmpty()) {
                    TreeNode curr = queue.remove();
                    if (curr != null) {
                        return false;
                    }
                }
                return true;
            }
            queue.add(remove.left);
            queue.add(remove.right);
        }
        return true;
    }
}
