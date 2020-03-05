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
        //每个位置作为根节点进行拆分
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftList = generateTree(start, i - 1);
            List<TreeNode> rightList = generateTree(i + 1, end);
            //处理左右节点，作为返回
            for (TreeNode left : leftList) {
                for (TreeNode right : rightList) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    cur.add(root);
                }
            }
        }

        return cur;
    }
}