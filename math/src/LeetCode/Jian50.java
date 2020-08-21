package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/20 1:39 下午
 * @description
 */
public class Jian50 {
    public char firstUniqChar(String s) {
        char[] strs = s.toCharArray();
        int[] flag = new int[128];
        for (int i = 0; i < strs.length; i++) {
            flag[strs[i]]++;
        }
        for (int i = 0; i < strs.length; i++) {
            if(flag[strs[i]] == 1)
                return strs[i];
        }
        return ' ';
    }
}
