package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/9/4 11:48 上午
 * @description
 */
public class leetcode1004 {
    public int longestOnes(int[] A, int K) {
        int l = 0;
        int r = 0;
        int res = 0;
        int zero = 0;
        for (; r < A.length; r++) {
            if (A[r] == 0) {
                zero++;
            }
            while (zero > K) {
                if (A[l++] == 0) {
                    zero--;
                }
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
