package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/6 9:37 下午
 * @description
 */
public class leetcode416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        int mid = sum / 2;
        return dfs(nums, nums.length - 1, mid, mid);
    }

    private boolean dfs(int[] nums, int index, int left, int right) {
        if (left == 0 && right == 0) {
            return true;
        } else if (left < 0 || right < 0 || index < 0) {
            return false;
        } else {
            return dfs(nums, index - 1, left - nums[index], right) ||
                    dfs(nums, index - 1, left, right - nums[index]);
        }
    }
}
