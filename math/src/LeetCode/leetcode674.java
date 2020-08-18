package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/18 6:42 下午
 * @description
 */
public class leetcode674 {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = 0;
        int curr = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                curr++;
            } else {
                max = Math.max(max, curr);
                curr = 1;
            }
        }
        return Math.max(curr, max);
    }
}
