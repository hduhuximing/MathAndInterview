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

    public boolean canPartition1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        int len = nums.length;
        // 创建二维状态数组，行：物品索引，列：容量（包括 0）
        boolean[][] dp = new boolean[len][target + 1];

        // 先填表格第 0 行，第 1 个数只能让容积为它自己的背包恰好装满
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }
        // 再填表格后面几行
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= target; j++) {
                // 直接从上一行先把结果抄下来，然后再修正
                dp[i][j] = dp[i - 1][j];

                if (nums[i] == j) {
                    dp[i][j] = true;
                    continue;
                }
                if (nums[i] < j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[len - 1][target];
    }
}
