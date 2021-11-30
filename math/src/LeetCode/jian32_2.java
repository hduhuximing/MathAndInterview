package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ming
 * @version 1.0
 * @date 2021/10/31 12:24 下午
 * @description
 */
public class jian32_2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        help(res, root, 0);
        return res;
    }

    private void help(List<List<Integer>> res, TreeNode root, int index) {
        if (root == null) {
            return;
        }
        if (res.size() == index) {
            res.add(new ArrayList<>());
        }
        res.get(index).add(root.val);
        help(res, root.left, index + 1);
        help(res, root.right, index + 1);
    }
}
