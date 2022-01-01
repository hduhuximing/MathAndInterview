package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2021/12/28 11:42 PM
 * @description
 */
public class leetcode567 {
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() > s2.length()) {
            return false;
        }
        int[] ch = new int[26];
        //填充s1
        for (int i = 0; i < s1.length(); i++) {
            ch[s1.charAt(i) - 'a']++;
        }
        //滑动到s1长度
        int start = 0;
        int end = 0;
        int count = s1.length();
        for (; end < s1.length(); end++) {
            if (--ch[s2.charAt(end) - 'a'] >= 0) {
                //命中
                count--;
            }
        }
        if (count == 0) {
            return true;
        }
        for (; end < s2.length(); end++) {
            //左边去掉一个
            if (ch[s2.charAt(start) - 'a']++ >= 0) {
                count++;
            }
            start++;
            if (--ch[s2.charAt(end) - 'a'] >= 0) {
                //命中
                count--;
            }
            if (count == 0) {
                return true;
            }
        }
        return false;
    }
}
