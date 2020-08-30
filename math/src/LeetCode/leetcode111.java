package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/15 2:23 下午
 * @description
 */
public class leetcode111 {
    public int minDepth(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        int l = minDepth(root.left);
//        int r = minDepth(root.right);
//        if (l == 0 || r == 0) {
//            return l + r + 1;
//        }
//        return Math.min(l, r) + 1;
        if (root == null) {
            return 0;
        }
        int depth = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (curr.left == null && curr.right == null) {
                    return depth;
                }
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            depth++;
        }
        return depth;
    }
}
