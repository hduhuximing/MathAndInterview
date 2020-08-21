package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ming
 * @version 1.0
 * @date 2020/7/7 8:29 下午
 * @description
 */
public class leetcode199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        help(res, root, 0);
        return res;
    }

    private void help(List<Integer> res, TreeNode root, int level) {
        if (root == null) {
            return;
        }
        //level等于size时表示当期这行没有添加
        if (res.size() == level) {
            res.add(root.val);
        }
        help(res, root.right, level + 1);
        help(res, root.left, level + 1);
    }
}
