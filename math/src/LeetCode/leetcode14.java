package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/6/29 10:28 下午
 * @description
 */
public class leetcode14 {
    public String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        if (len <= 1) {
            return "";
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            min = Math.min(min, strs[i].length());
        }
        // 每个字母
        for (int i = 0; i < min; i++) {
            // 字符串数
            for (int j = 1; j < len; j++) {
                if(strs[0].charAt(i)!=strs[j].charAt(i)){
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0].substring(0,min);

    }
}
