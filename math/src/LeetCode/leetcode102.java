package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/17 3:36 下午
 * @description
 */
public class leetcode102 {
    List<List<Integer>> list = new LinkedList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return list;
        }
        help(root, 0);
        return list;
    }

    private void help(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (list.size() == level) {
            list.add(new ArrayList<>());
        }
        list.get(level).add(root.val);
        help(root.left, level + 1);
        help(root.right, level + 1);
    }

    public List<List<Integer>> levelOrder1(TreeNode root) {
        if (root == null) {
            return list;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < queue.size(); i++) {
                TreeNode curr = queue.poll();
                temp.add(curr.val);
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            list.add(temp);
        }
        return list;
    }
}
