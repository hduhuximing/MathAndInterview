package LeetCode;

import java.util.Arrays;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/27 11:03 下午
 * @description
 */
public class leetcode473 {
    boolean ans = false;

    public boolean makesquare(int[] nums) {
        int sum = 0;
        for (int num : nums)
            sum += num;
        if (sum == 0 || sum % 4 != 0)
            return false;
        int target = sum / 4;

        for (int num : nums)
            if (num > target)
                return false;
        //从大到小的回溯，效率更高
        Arrays.sort(nums);
        backtrack(nums.length - 1, nums, target, new int[4]);
        return ans;
    }

    private void backtrack(int cur, int[] nums, int target, int[] ints) {
        if (ans) {
            return;
        }

        if (cur == -1) {
            for (int anInt : ints) {
                if (anInt != target) {
                    return;
                }
            }
            ans = true;
            return;
        }

        for (int i = 0; i < 4; i++) {
            ints[i] += nums[cur];
            if (ints[i] <= target) {
                backtrack(cur - 1, nums, target, ints);
            }
            ints[i] -= nums[cur];
        }

    }
}
