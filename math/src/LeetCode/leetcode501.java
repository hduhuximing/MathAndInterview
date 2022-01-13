package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/19 11:14 上午
 * @description
 */
public class leetcode501 {
    private int max = 0;
    List<Integer> list = new ArrayList<>();
    private int count;
    private int value;

    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        help(root);
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
    private void help(TreeNode root) {
        if (root == null) {
            return;
        }
        help(root.left);
        if (root.val == value) {
            count++;
        } else {
            count = 1;
            value = root.val;
        }
        if (count == max) {
            list.add(value);
        } else if (count > max) {
            max = count;
            list.clear();
            list.add(value);
        }
        help(root.right);
    }
}
