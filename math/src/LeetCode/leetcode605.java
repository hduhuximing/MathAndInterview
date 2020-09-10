package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/9/9 12:14 下午
 * @description
 */
public class leetcode605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        int res = 0;
        for (int i = 0; i < len; i++) {
            if (flowerbed[i] == 1) {
                continue;
            }
            int pre = i == 0 ? 0 : flowerbed[i - 1];
            int after = i == len - 1 ? 0 : flowerbed[i + 1];
            if (pre == 0 && after == 0) {
                res++;
                flowerbed[i] = 1;
            }
        }
        return res >= n;
    }
}
