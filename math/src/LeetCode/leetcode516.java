package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/28 11:58 上午
 * @description
 */
public class leetcode516 {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                }else{
                    dp[i][j]= Math.max(dp[i][j-1],dp[i+1][j]);
                }
            }
        }
        return dp[n-1][n-1];
    }
}
