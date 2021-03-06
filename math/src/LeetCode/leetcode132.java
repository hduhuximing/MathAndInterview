package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/3/2 3:17 下午
 * @description
 */
public class leetcode132 {
    public int minCut(String s) {
        char[]chars=s.toCharArray();
        //i个数的分割数
        int[] dp=new int[s.length()+1];
        for (int i = 0; i <=s.length() ; i++) {
            dp[i]=i-1;
        }
        for(int i=0;i<s.length();i++){
            help(chars,i,i,dp);
            help(chars,i,i+1,dp);
        }
        return dp[s.length()];

    }

    private void help(char[] chars, int i, int j, int[] dp) {
        while (i >= 0 && j <= chars.length - 1 && chars[i] == chars[j]) {
            dp[j + 1] = Math.min(dp[j + 1], dp[i] + 1);
            i--;
            j++;
        }
    }
}