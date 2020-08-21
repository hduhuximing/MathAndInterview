package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/19 10:10 上午
 * @description
 */
public class leetcode213 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int len = nums.length;
        return Math.max(help(nums, 0, len - 2), help(nums, 1, len - 1));
    }

    private int help(int[] nums, int start, int end) {
        int pre = nums[start];
        int curr = nums[start];
        int temp = nums[start];
        for (int i = start + 1; i <= end; i++) {
            temp = curr;
            curr = Math.max(curr, pre + nums[i]);
            pre = temp;
        }
        return curr;
    }
}
