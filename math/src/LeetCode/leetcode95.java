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
        //跳出条件
        if (start > end) {
            cur.add(null);
            return cur;
        }
        //递归拼接，以当前节点为根节点，获取左边的节点和右边的节点list
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

    public List<TreeNode> generateTrees1(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return generateTree1(1, n);
    }

    public List<TreeNode> generateTree1(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null);
            return res;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTree = generateTree1(start, i - 1);
            List<TreeNode> rightTree = generateTree1(i + 1, end);
            for (TreeNode le : leftTree) {
                for (TreeNode ri : rightTree) {
                    TreeNode root = new TreeNode(i);
                    root.left = le;
                    root.right = ri;
                    res.add(root);
                }
            }
        }
        return res;
    }

}