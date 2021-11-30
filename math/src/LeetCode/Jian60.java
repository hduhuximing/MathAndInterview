package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/13 5:54 下午
 * @description
 */
public class Jian60 {
//    public double[] twoSum(int n) {
//        double[] res = {1 / 6d, 1 / 6d, 1 / 6d, 1 / 6d, 1 / 6d, 1 / 6d};
//        if (n == 1) {
//            return res;
//        }
//        for (int i = 2; i <= n; i++) {
//            double[] temp = new double[5 * i + 1];
//            for (int k = 0; k < res.length; k++) {
//                for (int j = 0; j < 6; j++) {
//                    temp[k + j] += res[j] / 6;
//                }
//            }
//            res = temp;
//        }
//        return res;
//    }

    public double[] twoSum(int n) {
        //a个筛子的当前点数b
        int[][] dp = new int[n + 1][6 * n + 1];
        double all = Math.pow(6, n);
        double[] res = new double[5 * n + 1];
        for (int i = 1; i <= 6; i++) {
            dp[1][i] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= 6 * n; j++) {
                for (int k = 1; k <= 6; k++) {
                    dp[i][j] += j > k ? dp[i - 1][j - k] : 0;
                    if (i == n) {
                        res[j - n] = dp[n][j] / all;
                    }
                }
            }
        }
        return res;
    }

    public double[] twoSum1(int n) {
        int[][] dp = new int[n + 1][6 * n + 1];
        double[] res = new double[5 * n + 1];
        double all = Math.pow(6, n);
        for (int i = 1; i <= 6; i++) {
            dp[1][i] = 1;
        }
        for (int i = 1; i <= 6; i++) {
            for (int j = i; j <= 6 * n; j++) {
                for (int k = 1; k <= 6; k++) {
                    dp[i][j] = j > k ? dp[i - 1][j - k] : 0;
                    if (i == n) {
                        res[j - n] = dp[i][j] / all;
                    }
                }
            }
        }
        return res;
    }


}
