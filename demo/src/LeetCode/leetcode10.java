package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/3/6 11:56 上午
 * @description
 */
public class leetcode10 {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*' && i > 0 && dp[0][i - 1]) {
                dp[0][i + 1] = true;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if ((s.charAt(i) == p.charAt(j)) || p.charAt(j) == '.') {
                    dp[i + 1][j + 1] = dp[i][j];
                } else if(p.charAt(j)=='*'){
                    //当前是*  之前一个位置不匹配
                    if(p.charAt(j-1)!=s.charAt(i)&&p.charAt(i-1)!='.'){
                        //去掉a*
                        dp[i+1][j+1]=dp[i][j-1];
                    }else{
                        //匹配了
                        dp[i+1][j+1]=dp[i+1][j]||dp[i+1][j-1]||dp[i][j+1];
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
