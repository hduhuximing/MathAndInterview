package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/6 11:44 下午
 * @description 有序的时候，等于初始化的start和end 因此需要做处理，消掉+1
 */
public class leetcode581 {
    public int findUnsortedSubarray(int[] nums) {
        int start = 1;
        int end = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            if (max > nums[i]) {
                end = i;
            }
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            min = Math.min(min, nums[i]);
            if (min < nums[i]) {
                start = i;
            }
        }
        return end - start + 1;

    }
}
