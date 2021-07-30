package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/15 2:45 下午
 * @description
 */
public class leetcode171 {
    public int titleToNumber(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - 'A' + 1;
            res = res * 26 + num;
        }
        return res;
    }
}
