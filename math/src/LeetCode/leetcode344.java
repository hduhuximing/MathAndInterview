package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2021/12/28 10:33 PM
 * @description
 */
public class leetcode344 {
    public void reverseString(char[] s) {
        int len = s.length;
        int start = 0, end = len - 1;
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
}
