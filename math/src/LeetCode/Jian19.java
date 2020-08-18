package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/18 9:15 下午
 * @description
 */
public class Jian19 {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i < p.length(); i++) {
            if (i > 0 && p.charAt(i) == '*' && dp[0][i - 1]) {
                dp[0][i + 1] = true;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else if (p.charAt(j) == '*') {
                    if (j > 0) {
                        if (p.charAt(j - 1) != '.' && s.charAt(i) != p.charAt(j - 1)) {
                            dp[i + 1][j + 1] = dp[i + 1][j - 1];
                        } else {
                            //前一个是匹配的
                            dp[i + 1][j + 1] = dp[i + 1][j] || dp[i + 1][j - 1] || dp[i][j + 1];
                        }
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
