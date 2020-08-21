package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/20 1:21 下午
 * @description
 */
public class Jian47 {
    public int maxValue(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int[] dp = new int[grid[0].length];
        for (int i = 0; i < grid[0].length; i++) {
            if (i == 0) {
                dp[i] = grid[0][0];
            } else {
                dp[i] = grid[0][i] + dp[i - 1];
            }
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (j > 0) {
                    dp[j] = Math.max(dp[j], dp[j - 1]) + grid[i][j];
                }else{
                    dp[j]+=grid[i][0];
                }
            }
        }
        return dp[grid[0].length - 1];
    }
}
