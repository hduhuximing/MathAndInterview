package LeetCode;

import sun.jvm.hotspot.oops.Array;

import java.util.Arrays;

/**
 * @author ming
 * @version 1.0
 * @date 2020/3/9 2:06 下午
 * @description
 */
public class leetcode452 {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        Arrays.sort(points, (o1, o2) -> o1[1] - o2[1]);
        int res = 1;
        int currEnd = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (currEnd >= points[i][0]) {
                continue;
            }
            res++;
            currEnd = points[i][1];
        }
        return res;
    }
}
