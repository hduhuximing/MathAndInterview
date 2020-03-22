package LeetCode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author ming
 * @version 1.0
 * @date 2020/3/9 3:52 下午
 * @description
 */
public class leetcode128 {
    //没有前置值，以当前位置作为开始向后查找。
    //找开始位置
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int currNum = 0;
        int curr = 1;
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i] - 1)) {
                currNum = nums[i] + 1;
                curr = 1;
                while (set.contains(currNum)) {
                    curr++;
                    currNum++;
                }
                max = Math.max(max, curr);
            }
        }
        return max;
    }
}
