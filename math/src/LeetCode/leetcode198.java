package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/7/27 11:00 下午
 * @description
 */
public class leetcode198 {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }
        int pre = nums[0];
        int temp = nums[0];
        int curr = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            temp = curr;
            curr = Math.max(curr, nums[i] + pre);
            pre = temp;
        }
        return curr;
    }
}
