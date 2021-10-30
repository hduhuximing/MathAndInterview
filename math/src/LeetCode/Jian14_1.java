package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/16 2:42 下午
 * @description
 */
public class Jian14_1 {
    public int cuttingRope(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (n == 2 || n == 3) {
            return n - 1;
        }
        /*
          dp[i]长度为i时，最大的乘积 dp[i]=max(dp[i],dp[i-j]*dp[j])
          j 是被分割的一部分长度，取值范围为1~i/2,因为大于i/2就重复了
         */
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] * dp[j]);
            }
        }
        return dp[n];
    }
}
