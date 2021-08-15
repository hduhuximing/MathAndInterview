package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/19 4:37 下午
 * @description
 */
public class Jian34 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        help(res, root, sum, new ArrayList<>());
        return res;
    }

    // 回溯
    public void help(List<List<Integer>> res, TreeNode root, int sum, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        sum -= root.val;
        list.add(root.val);
        if (sum == 0 && root.left == null && root.right == null) {
            res.add(new ArrayList<>(list));
        } else {
            help(res, root.left, sum, list);
            help(res, root.right, sum, list);
        }

        list.remove(list.size() - 1);
    }
}
