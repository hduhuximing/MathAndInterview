package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/6/3 11:04 上午
 * @description
 */
public class leetcode174 {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) {
            return 0;
        }
        int row = dungeon.length;
        int col = dungeon[0].length;
        int[][] dp = new int[row][col];
        dp[row - 1][col - 1] = dungeon[row - 1][col - 1] > 1 ? 1 : 1 - dungeon[row - 1][col - 1];
        for (int i = col - 2; i >= 0; i--) {
            dp[row - 1][i] = Math.max(1, dp[row - 1][i + 1] - dungeon[row - 1][i]);
        }
        for (int j = row - 2; j >= 0; j--) {
            dp[j][col - 1] = Math.max(1, dp[j][col - 1] - dungeon[j + 1][col - 1]);
        }
        int right = 0;
        int down = 0;
        for (int i = row - 2; i >= 0; i--) {
            for (int j = col - 2; j >= 0; j--) {
                right = Math.max(1, dp[i][j + 1] - dungeon[i][j]);
                down = Math.max(1, dp[i + 1][j] - dungeon[i][j]);
                dp[i][j] = Math.min(right, down);
            }
        }
        return dp[0][0];
    }
}