package LeetCode;

import java.util.Arrays;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/24 12:26 下午
 * @description
 */
public class leetcode1561 {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int len = piles.length;
        int l = 0;
        int r = len - 2;
        int res = 0;
        while (l < r) {
            res += piles[r];
            l++;
            r = r - 2;
        }
        return res;
    }
}
