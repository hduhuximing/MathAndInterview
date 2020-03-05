package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ming
 * @version 1.0
 * @date 2020/2/12 10:50 上午
 * @description
 */
public class leetcode257 {
    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        help(res, root, "");
        return res;
    }

    private void help(List<String> res, TreeNode root, String curr) {
        if (root == null) {
            return;
        }
        curr += root.val;
        if (root.left == null && root.right == null) {
            res.add(curr);
        } else {
            curr += "->";
            help(res, root.left, curr);
            help(res, root.right, curr);
        }

    }
}