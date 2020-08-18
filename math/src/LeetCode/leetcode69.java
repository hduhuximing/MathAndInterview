package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/15 1:54 下午
 * @description
 */
public class leetcode69 {
    public int mySqrt(int x) {
        int start = 1;
        int end = x;
        int res = 0;
        int mid = (end - start) / 2 + start;
        while (start <= end) {
            int curr = x / mid;
            if (curr > mid) {
                start = mid + 1;
                res = mid;
            } else if (curr < mid) {
                end = mid - 1;
            } else {
                return mid;
            }
            mid = (end - start) / 2 + start;
        }
        return res;
    }
}
