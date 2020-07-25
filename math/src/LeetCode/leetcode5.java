package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/3/6 11:26 上午
 * @description
 */
public class leetcode5 {
    public String longestPalindrome(String s) {
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
        while (i >= 0 && j < s.length() - 1) {
            if (s.charAt(i) == s.charAt(j)) {
                i--;
                j++;
            } else {
                break;
            }
        }
        return s.substring(i + 1, j);
    }
}
