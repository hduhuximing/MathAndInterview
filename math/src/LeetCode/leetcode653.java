package LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ming
 * @version 1.0
 * @date 2020/9/14 1:14 下午
 * @description
 */
public class leetcode653 {
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        //层次遍历
        return find(set, root, k);
    }

    private boolean find(Set<Integer> set, TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        if (set.contains(k - root.val)) {
            return true;
        }
        set.add(root.val);
        return find(set, root.left, k) || find(set, root.right, k);
    }
}
