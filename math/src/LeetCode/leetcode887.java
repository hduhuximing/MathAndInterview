package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/7/30 3:52 下午
 * @description
 */
public class leetcode887 {
    public int superEggDrop(int K, int N) {
        //鸡蛋k个，最多投N次
        int[][] dp = new int[K + 1][N + 1];
        //m次机会
        int m = 0;
        while (dp[K][m] < N) {
            m++;
            for (int i = 1; i <= K; i++) {
                dp[i][m] = dp[i][m - 1] + dp[i - 1][m - 1] + 1;
            }
        }
        return m;
    }
}
