package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ming
 * @version 1.0
 * @date 2020/1/30 7:45 下午
 */


public class leetcode95 {
    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return generateTree(1, n);
    }

    private List<TreeNode> generateTree(int start, int end) {
        List<TreeNode> cur = new ArrayList<>();
        if (start > end) {
            cur.add(null);
            return cur;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> left = generateTree(start, i - 1);
            List<TreeNode> right = generateTree(i + 1, end);
            for (TreeNode le : left) {
                for (TreeNode ri : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = le;
                    root.right = ri;
                    cur.add(root);
                }
            }
        }
        return cur;
    }
}