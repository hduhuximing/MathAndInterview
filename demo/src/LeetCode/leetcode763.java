package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ming
 * @version 1.0
 * @date 2020/3/23 9:57 下午
 * @description
 */
public class leetcode763 {
    public List<Integer> partitionLabels(String S) {
        List<Integer> list = new ArrayList<>();
        int[] patt = new int[S.length()];
        for (int i = 0; i < S.length(); i++) {
            patt[S.charAt(i) - 'a'] = i;
        }
        //走的最远位置
        int curr = 0;
        int start = 0;
        for (int i = 0; i < S.length(); i++) {
            curr = Math.max(curr, patt[S.charAt(i) - 'a']);
            if (curr == i) {
                list.add(curr - start + 1);
                start = curr + 1;
            }
        }
        return list;
    }
}
