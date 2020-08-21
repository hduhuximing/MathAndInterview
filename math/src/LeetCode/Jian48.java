package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/20 1:26 下午
 * @description
 */
public class Jian48 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        int[] arr = new int[256];
        int pre = 0;
        int max = 0;
        for (int i = 0; i < len; i++) {
            pre = Math.max(pre, arr[s.charAt(i)]);
            max = Math.max(max, i - pre + 1);
            arr[s.charAt(i)] = i + 1;
        }
        return max;
    }
}
