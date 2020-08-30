package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/25 2:14 下午
 * @description
 */
public class leetcode67 {
    public String addBinary(String a, String b) {
        StringBuilder str = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int in = 0;
        while (i >= 0 || j >= 0) {
            if (i >= 0) {
                in += a.charAt(i--) - '0';
            }
            if (j >= 0) {
                in += b.charAt(j--) - '0';
            }
            str.append(in % 2);
            in /= 2;
        }
        if (in != 0) {
            str.append(in);
        }
        return str.reverse().toString();
    }
}
