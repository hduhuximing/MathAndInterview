package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/2/13 3:52 下午
 * @description
 */
public class leetcode494 {
    public static int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum < S || sum % 2 == 1) {
            return 0;
        }
        //正数和
        S = (S + sum) / 2;
        //求组合为当前S的数量
        int[] dp = new int[S + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = S; i >= num; i--) {
                dp[i] += dp[i - num];
            }
        }
        return dp[S];

//        if (nums == null || nums.length == 0) {
//            return 0;
//        }
//        return help(nums, S, 0, 0, 0);
    }

    private static int help(int[] nums, int S, int count, int index, int sum) {
        if (index == nums.length) {
            if (S == sum) {
                count++;
            }
            return count;
        }
        return help(nums, S, count, index + 1, sum - nums[index])
                + help(nums, S, count, index + 1, sum + nums[index]);
    }

    public static void main(String[] args) {
        int targetSumWays = findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3);
        System.out.println(targetSumWays);
    }
}
