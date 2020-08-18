package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/18 10:03 下午
 * @description
 */
public class leetcode107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        help(root, res, 0);
        return res;
    }

    private void help(TreeNode root, List<List<Integer>> res, int index) {
        if (root == null) {
            return;
        }
        if (res.size() == index) {
            res.add(0, new ArrayList<>());
        }
        res.get(res.size() - 1 - index).add(root.val);
        help(root.left, res, index + 1);
        help(root.right, res, index + 1);
    }
}
