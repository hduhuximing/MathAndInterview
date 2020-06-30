package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/2/2 2:29 下午
 */
public class leetcode256 {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        int n = costs.length;
        int dp[][] = new int[n][3];
        for (int i = 0; i < n; i++) {
            dp[0][i] = costs[0][i];
        }
        for (int i = 1; i < n; i++) {
            dp[i][0] = costs[i][0] + Math.min(dp[i][1], dp[i][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i][0], dp[i][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i][1], dp[i][0]);
        }
        return Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));
    }


}
