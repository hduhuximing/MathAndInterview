package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ming
 * @version 1.0
 * @date 2020/7/1 8:31 下午
 * @description
 */
public class leetcode78 {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return res;
        }
        help(nums, 0, new ArrayList<Integer>());
        return res;
    }

    private void help(int[] nums, int index, ArrayList<Integer> list) {
        res.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            help(nums, i + 1, list);
            list.remove(list.size() - 1);
        }
    }

}
