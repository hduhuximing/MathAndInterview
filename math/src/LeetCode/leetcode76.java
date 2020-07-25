package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/7/16 8:19 下午
 * @description
 */
public class leetcode76 {
    public String minWindow(String s, String p) {
        if (s == null || p == null || s.length() < p.length()) {
            return "";
        }
        int[] ch = new int[256];
        int count = p.length();
        for (int i = 0; i < count; i++) {
            ch[p.charAt(i)]++;
        }

        int start = 0;
        int end = 0;
        int min = Integer.MAX_VALUE;
        String res = "";
        int len = s.length();
        for (; end < len; end++) {
            ch[s.charAt(end)]--;
            if (ch[s.charAt(end)] >= 0) {
                count--;
            }
            while (start < end && ch[s.charAt(start)] < 0) {
                ch[s.charAt(start)]++;
                start++;
            }
            if (count == 0 && min > end - start + 1) {
                min = end - start + 1;
                res = s.substring(start, end + 1);
            }
        }
        return res;
    }
}
