package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/9/1 9:03 下午
 * @description
 */
public class leetcode209 {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int len = nums.length;
        int sum = 0;
        while (right < len) {
            sum += nums[right];
            while (left <= right && sum >= s) {
                res = Math.min(res, right - left + 1);
                sum -= nums[left++];
            }
            right++;
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
