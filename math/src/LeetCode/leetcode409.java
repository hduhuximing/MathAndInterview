package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/28 9:56 上午
 * @description
 */
public class leetcode409 {
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] count = new int[256];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'A']++;
        }
        int res = 0;
        for (int i = 0; i < count.length; i++) {
            res += count[i] % 2;
        }
        return res == 0 ? s.length() : s.length() - res + 1;
    }
}
