package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/20 1:34 下午
 * @description
 */
public class Jian49 {
    public int nthUglyNumber(int n) {
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        int val2 = 0;
        int val3 = 0;
        int val5 = 0;

        int currIndex = 1;
        int[] res = new int[n];
        res[0] = 1;
        int min = Integer.MAX_VALUE;
        while (currIndex < n) {
            val2 = res[index2] * 2;
            val3 = res[index3] * 3;
            val5 = res[index5] * 5;
            min = Math.min(val2, Math.min(val3, val5));
            res[currIndex++] = min;
            if (min == val2) {
                index2++;
            }
            if (min == val3) {
                index3++;
            }
            if (min == val5) {
                index5++;
            }
        }
        return res[n - 1];
    }
}
