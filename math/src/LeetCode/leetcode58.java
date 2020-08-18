package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/15 1:37 下午
 * @description
 */
public class leetcode58 {
    public int lengthOfLastWord(String a) {
        int end = a.length() - 1;
        while (end >= 0 && a.charAt(end) == ' ') {
            end--;
        }
        int start = end;
        while (start >= 0 && a.charAt(start) != ' ') {
            start--;
        }
        return end - start;
    }
}
