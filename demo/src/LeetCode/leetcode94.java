package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author ming
 * @version 1.0
 * @date 2020/3/9 3:39 下午
 * @description
 */


public class leetcode94 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode pop = stack.pop();
            res.add(pop.val);
            root = root.right;
        }
        return res;
    }
}
