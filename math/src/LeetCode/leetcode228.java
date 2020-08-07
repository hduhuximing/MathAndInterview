package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/2 10:33 上午
 * @description
 */
public class leetcode228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            i = j;
            while (j + 1 < nums.length && nums[j] + 1 == nums[j + 1]) {
                j++;
            }
            if (i == j) {
                res.add(nums[i] + "");
            } else {
                res.add(nums[i] + "->" + nums[j]);
            }
        }
        return res;
    }
}
