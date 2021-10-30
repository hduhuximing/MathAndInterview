package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/2/13 11:45 上午
 * @description 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 * 示例 2:
 * <p>
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/perfect-squares
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class leetcode279 {
    public int numSquares(int n) {
        if (n == 0) {
            return 0;
        }
        /*
          dp[i]代表i之前（包含i）的完全平方数，从1开始算
          dp[i]=max(dp[i],dp[i-j*j]+1)
          j*j一定是一个完全平方
         */
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            //全1是最大的
            dp[i] = i;
            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
