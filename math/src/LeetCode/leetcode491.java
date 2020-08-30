package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/25 3:49 下午
 * @description
 */
public class leetcode491 {
    public List<List<Integer>> findSubsequences(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> temp = new ArrayList<>();
        dfs(nums, 0, temp, set);
        return new ArrayList<>(set);
    }

    private void dfs(int[] nums, int index, List<Integer> temp, Set<List<Integer>> set) {
        if (temp.size() > 1) {
            set.add(new ArrayList<>(temp));
        }
        for (int i = index; i < nums.length; i++) {
            if (!temp.isEmpty() && temp.get(temp.size() - 1) > nums[i]) {
                continue;
            }
            temp.add(nums[i]);
            dfs(nums, i + 1, temp, set);
            temp.remove(temp.size() - 1);
        }
    }
}
