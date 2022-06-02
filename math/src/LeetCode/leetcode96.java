package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/2/12 10:30 下午
 * @description
 */
public class leetcode96 {
    public static int numTrees(int n) {
        if (n == 1 || n == 0) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
//            左边节点数为j，右边节点数为i-j-1，1是因为有根节点
//            for (int j = 0; j < i; j++) {
//                dp[i] = dp[j] * dp[i - j - 1];
//            }

            //第j个节点为根节点
            for (int j = 1; j <= i; j++) {
                //差分成前面和后面
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int i = numTrees(3);
        System.out.println(i);
    }


    public static int numTrees1(int n) {
        if (n == 1 || n == 0) {
            return n;
        }
        int[] dp = new int[n + 1];//i个节点的排列数
        dp[0] = 1;
        dp[1] = 1;
        // 一共有i个节点
        for (int i = 2; i <= n; i++) {
            //第j个节点为根节点
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

}
