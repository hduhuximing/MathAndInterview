package LeetCode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author ming
 * @version 1.0
 * @date 2020/9/12 6:00 下午
 * @description
 */
public class leetcode637 {
    public List<Double> averageOfLevels(TreeNode root) {
        LinkedList<Double> res = new LinkedList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();

        if (root == null) {
            return res;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            double avg = 0;
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                avg += curr.val;
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            avg = avg / size;
            res.add(avg);
        }
        return res;


    }
}
