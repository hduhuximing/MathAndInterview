package LeetCode;

import java.util.Arrays;

/**
 * @author ming
 * @version 1.0
 * @date 2021/10/20 12:11 上午
 * @description
 */
public class leetcode453 {

    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i] - nums[0];
        }
        return count;
    }
}
