package LeetCode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author ming
 * @version 1.0
 * @date 2020/9/8 1:48 下午
 * @description
 */
public class leetcode1288 {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //这里要取到最大的返回，左边最左，右边是当前相同的最右边。
                return o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0];
            }
        });
        int count = 0;
        int end = 0;
        int pre_end = 0;
        for (int[] curr : intervals) {
            end = curr[1];
            if(pre_end<end){
                pre_end=end;
                count++;
            }
        }
        return count;
    }
}