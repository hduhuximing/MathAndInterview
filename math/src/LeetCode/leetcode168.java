package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/15 2:41 下午
 * @description
 */
public class leetcode168 {
    public String convertToTitle(int n) {
        if (n == 0) {
            return "";
        }
        StringBuilder str = new StringBuilder();
        while (n > 0) {
            n--;
            str.append((char) ('A' + n % 26));
            n /= 26;
        }
        return str.reverse().toString();
    }
}
