package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author ming
 * @version 1.0
 * @date 2020/3/25 8:30 下午
 * @description
 */
public class leetcode652 {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        if (root == null) {
            return res;
        }
        help(root, res, map);
        return res;
    }

    private String help(TreeNode root, List<TreeNode> res, HashMap<String, Integer> map) {
        if (root == null) {
            return "*";
        }
        String curr = root.val + "," + help(root.left, res, map) + "," + help(root.right, res, map);
        if (map.containsKey(curr)) {
            if (map.get(curr) == 1) {
                res.add(root);
                map.put(curr, map.getOrDefault(curr, 0) + 1);
            }
        } else {
            map.put(curr, 1);
        }
        return curr;
    }
}
