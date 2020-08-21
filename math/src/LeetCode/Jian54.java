package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/20 2:16 下午
 * @description
 */
public class Jian54 {

    List<Integer> list = new ArrayList<>();

    public int kthLargest(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        help(root);
        return list.get(list.size() - k);
    }

    public void help(TreeNode root) {
        if (root == null) {
            return;
        }
        help(root.left);
        list.add(root.val);
        help(root.right);
    }
}
