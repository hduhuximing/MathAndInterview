package LeetCode;

import java.util.Arrays;

/**
 * @author ming
 * @version 1.0
 * @date 2020/9/4 9:51 上午
 * @description
 */
public class leetcode16_06 {
    public int smallestDifference(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        long ans = Integer.MAX_VALUE;

        int i = 0, j = 0;
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                ans = Math.min(ans, (long) b[j] - (long) a[i]);
                ++i;
            } else if (a[i] > b[j]) {
                ans = Math.min(ans, (long) a[i] - (long) b[j]);
                ++j;
            } else {
                return 0;
            }
        }
        return (int) ans;
    }
}
