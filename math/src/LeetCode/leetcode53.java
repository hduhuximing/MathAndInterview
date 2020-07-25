package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/7/14 9:55 下午
 * @description
 */
public class leetcode53 {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int curr = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curr = Math.max(curr + nums[i], nums[i]);
            max = Math.max(curr, max);
        }
        return max;
    }
}
