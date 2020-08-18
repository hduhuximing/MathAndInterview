package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/18 7:44 下午
 * @description
 */
public class leetcode518 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}
