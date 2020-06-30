package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ming
 * @version 1.0
 * @date 2020/3/2 6:36 下午
 * @description
 */
public class leetcode131 {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }

        //dp[i][j]从i到j是否可以回文
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 1; i < s.length(); i++) {
            dp[i][i] = 1;
        }
        help(s, 0, res, list, dp);
        return res;
    }

    private void help(String s, int index, List<List<String>> res, List<String> list, int[][] dp) {
        if (index == s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (isTrue(s, index, i, dp)) {
                list.add(s.substring(index, i + 1));
                help(s, i + 1, res, list, dp);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isTrue(String s, int start, int end, int[][] dp) {
        if (dp[start][end] == 1) {
            return true;
        } else if (dp[start][end] == 2) {
            return false;
        } else {
            while (start < end) {
                if (s.charAt(start) != s.charAt(end)) {
                    dp[start][end] = 2;
                    return false;
                }
                start++;
                end--;
            }
            dp[start][end] = 1;
            return true;
        }
    }

    public static void main(String[] args) {
        leetcode131 le = new leetcode131();
        List<List<String>> aab = le.partition("aab");
        for (List<String> strings : aab) {
            for (String string : strings) {
                System.out.println(string);
            }
        }
    }
}