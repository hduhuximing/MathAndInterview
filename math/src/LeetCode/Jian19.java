package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/18 9:15 下午
 * @description https://leetcode-cn.com/problems/zheng-ze-biao-da-shi-pi-pei-lcof/solution/dong-tai-gui-hua-he-di-gui-liang-chong-fang-shi-ji/ 解析
 */
public class Jian19 {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        //前i个和前j个的匹配与否
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i < p.length(); i++) {
            if (i > 0 && p.charAt(i) == '*' && dp[0][i - 1]) {
                dp[0][i + 1] = true;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                //匹配上
                if (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else if (p.charAt(j) == '*') {
                    if (j > 0) {
                        //干掉a*
                        if (p.charAt(j - 1) != '.' && p.charAt(j - 1) != s.charAt(i)) {
                            dp[i + 1][j + 1] = dp[i + 1][j - 1];
                        } else {
                            dp[i + 1][j + 1] = dp[i + 1][j - 1] || dp[i + 1][j] || dp[i][j + 1];
                        }
                    }
                }
            }
        }


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
