package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ming
 * @version 1.0
 * @date 2020/9/14 1:39 下午
 * @description
 */
public class leetcode897 {
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        help(root, list);
        TreeNode curr = new TreeNode(0);
        TreeNode move = curr;
        for (int li : list) {
            move.right = new TreeNode(li);
            move = move.right;
        }
        return curr.right;
    }

    private void help(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        help(root.left, list);
        list.add(root.val);
        help(root.right, list);
    }
}
