package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/9/4 9:47 上午
 * @description
 */
public class leetcode17_11 {
    public int findClosest(String[] words, String word1, String word2) {
        int res = Integer.MAX_VALUE;
        int index1 = -1;
        int index2 = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                index1 = i;
            }
            if (words[i].equals(word2)) {
                index2 = i;
            }
            if (index1 == -1 || index2 == -1) {
                continue;
            }
            res = Math.min(res, Math.abs(index1 - index2));
        }
        return res;
    }
}
