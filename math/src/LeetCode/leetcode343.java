package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/29 11:02 上午
 * @description
 */
public class leetcode343 {
    public int integerBreak(int n) {
//        int[] dp = new int[n + 1];
//        Arrays.fill(dp, 1);
//        for (int i = 2; i <= n; i++) {
//            for (int j = 1; j < i; j++) {
//                dp[i] = Math.max(dp[i], Math.max(dp[i - j] * j, (i - j) * j));
//            }
//        }
//        return dp[n];
        if (n < 4) {
            return n - 1;
        }
        int a = n / 3;
        int b = n % 3;
        if (b == 0) {
            return (int) Math.pow(3, a);
        }
        if (b == 1) {
            return (int) Math.pow(3, a - 1) * 4;
        }
        return (int) Math.pow(3, a) * 2;
    }
}
