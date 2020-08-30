package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/24 3:41 下午
 * @description
 */
public class leetcode11 {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int curr = 0;
        int res = Integer.MIN_VALUE;
        while (l < r) {
            int min = Math.min(height[l], height[r]);
            curr = min * (r - l);
            res = Math.max(res, curr);
            while (l < r && height[l] <= min) {
                l++;
            }
            while (l < r && height[r] <= min) {
                r--;
            }
        }
        return res;

    }
}
