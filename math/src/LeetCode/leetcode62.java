package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/7/1 8:20 下午
 * @description
 */
public class leetcode62 {
    public int uniquePaths(int m, int n) {
        //1 先填充i=0和j=0的情况
//        int[][] dp = new int[m][n];
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if(i==0||j==0){
//                    dp[i][j]=1;
//                }else{
//                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
//                }
//            }
//        }
//        return dp[m-1][n-1];
        //2
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j > 0) {
                    dp[j] += dp[j - 1];
                }
            }
        }
        return dp[n - 1];
    }
}
