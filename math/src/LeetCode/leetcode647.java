package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/3/5 2:35 下午
 * @description
 */
public class leetcode647 {

    public int countSubstrings1(String s) {
        //dp
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int count = len;
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int i = 0; i < len - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                count++;
            }
        }
        for (int i = 3; i <= len; i++) {
            for (int j = 0; j + i <= len; j++) {
                int k = j + len - 1;
                if (s.charAt(k) == s.charAt(j)) {
                    dp[j][k] = dp[j + 1][k - 1];
                    count++;
                }
            }
        }
        return count;
    }


    private int sum = 0;

    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        for (int i = 0; i < s.length(); i++) {
            count(s, i, i);
            count(s, i, i + 1);
        }
        return sum;
    }

    private void count(String s, int i, int j) {
        while (i >= 0
                && j <= s.length() - 1
                && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
            sum++;
        }
    }

    public static void main(String[] args) {
        leetcode647 le = new leetcode647();
        int abc = le.countSubstrings("abc");
        System.out.println(abc);
    }
}
