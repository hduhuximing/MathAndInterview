package LeetCode;

import java.util.List;

/**
 * @author ming
 * @version 1.0
 * @date 2020/2/12 10:42 上午
 * @description
 */
public class leetcode139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return false;
        }
        int len = s.length();
        boolean[] res = new boolean[len + 1];
        res[0] = true;
        for (int i = 1; i <= len; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (wordDict.contains(s.substring(j, i)) && res[j]) {
                    res[i] = true;
                    break;
                }
            }
        }
        return res[len];
    }
}
