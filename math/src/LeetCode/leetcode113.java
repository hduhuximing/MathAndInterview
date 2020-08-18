package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/17 2:04 下午
 * @description
 */
public class leetcode113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return res;
        }
        help(res, list, root, sum);
        return res;
    }

    private void help(List<List<Integer>> res, List<Integer> list, TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        sum -= root.val;
        list.add(root.val);
        if (sum == 0 && root.left == null && root.right == null) {
            res.add(new ArrayList<>(list));
        } else {
            help(res, list, root.left, sum);
            help(res, list, root.right, sum);
        }

        list.remove(list.size() - 1);

    }
}
