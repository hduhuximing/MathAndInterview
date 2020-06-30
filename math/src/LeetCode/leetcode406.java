package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ming
 * @version 1.0
 * @date 2020/3/9 8:11 下午
 * @description
 */
public class leetcode406 {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0) {
            return new int[0][0];
        }
        Arrays.sort(people, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]));
        List<int[]> res = new ArrayList<>();
        for (int[] person : people) {
            res.add(person[1], person);
        }
        return res.toArray(new int[res.size()][]);
    }
}
