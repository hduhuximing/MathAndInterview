package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/3/6 11:26 上午
 * @description
 */
public class leetcode5 {
    public String longestPalindrome(String s) {

        //dp[i][j],i到j中最长的回文数
        // dp[i][j]=dp[i+1][j-1]+2
//        int n = s.length();
//        // dp 数组全部初始化为 0
//        int[][] dp = new int[n][n];
//        // base case
//        for (int i = 0; i < n; i++)
//            dp[i][i] = 1;
//        // 反着遍历保证正确的状态转移
//        for (int i = n - 1; i >= 0; i--) {
//            for (int j = i + 1; j < n; j++) {
//                // 状态转移方程
//                if (s.charAt(i) == s.charAt(j))
//                    dp[i][j] = dp[i + 1][j - 1] + 2;
//                else
//                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
//            }
//        }
//        // 整个 s 的最长回文子串长度
//        return dp[0][n - 1];


        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxlen = 1;
        String res = s.substring(0, 1);
        for (int i = 0; i < len; i++) {
            String odd = help(s, i, i);
            String even = help(s, i, i + 1);
            String maxStr = odd.length() > even.length() ? odd : even;
            if (maxStr.length() > maxlen) {
                maxlen = maxStr.length();
                res = maxStr;
            }
        }
        return res;
    }

    private String help(String s, int i, int j) {
        while (i >= 0 && j <= s.length() - 2) {
            if (s.charAt(i) == s.charAt(j)) {
                i--;
                j++;
            } else {
                break;
            }
        }
        //包头不包尾
        return s.substring(i + 1, j);
    }
}
