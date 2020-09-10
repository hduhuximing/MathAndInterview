package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/9/4 11:21 上午
 * @description
 */
public class leetcode1234 {
    public int balancedString(String s) {
        // 统计每个单词的数目
        int[] count = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            count[s.charAt(i) - 'A']++;
        }
        int num = s.length() / 4;
        int i;
        for (i = 0; i < 26; i++) {
            if (count[i] != 0) {
                if (num != count[i] / 4) {
                    break;
                }
            }
        }
        if (i == 26) {
            return 0;
        }
        int left = 0, right = 0;
        int ret = n;
        for (; right < n; right++) {
            count[s.charAt(right) - 'A']--;
            // 注意此处 left是小于 n（而不是小于right）;因为窗口最小可以为0，这个时候left是大于right的
            while (left <= right
                    && count['Q' - 'A'] <= n / 4
                    && count['W' - 'A'] <= n / 4
                    && count['E' - 'A'] <= n / 4
                    && count['R' - 'A'] <= n / 4) {
                ret = Math.min(ret, right - left + 1);
                count[s.charAt(left) - 'A']++;
                left++;
            }
        }
        return ret;
    }
}
