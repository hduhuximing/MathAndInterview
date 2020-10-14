package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ming
 * @version 1.0
 * @date 2020/9/14 1:30 下午
 * @description
 */
public class leetcode872 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList();
        List<Integer> leaves2 = new ArrayList();
        dfs(root1, leaves1);
        dfs(root2, leaves2);
        return leaves1.equals(leaves2);
    }

    private void dfs(TreeNode root, List<Integer> curr) {
        if (root == null) {
            return;
        }
        dfs(root.left, curr);
        if (root.left == null && root.right == null) {
            curr.add(root.val);
        }
        dfs(root.right, curr);
    }
}
