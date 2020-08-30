package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/24 12:19 下午
 * @description
 */
public class leetcode5495 {
    public List<Integer> mostVisited(int n, int[] rounds) {
        List<Integer> list = new ArrayList<>();
        int len = rounds.length;
        int left = rounds[0];
        int right = rounds[len - 1];
        if (left <= right) {
            for (int i = left; i <= right; i++) {
                list.add(i);
            }
        } else {
            for (int i = 1; i <= right; i++) {
                list.add(i);
            }
            for (int i = left; i < n; i++) {
                list.add(i);
            }
        }
        return list;
    }
}
