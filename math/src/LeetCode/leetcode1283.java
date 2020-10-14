package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/9/19 8:24 下午
 * @description 向上取整 使结果不超过阈值的最小除数
 */
public class leetcode1283 {
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1;
        int right = 1000001;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            int sum = 0;
            for (int num : nums) {
                //向上取整
                sum += (num + mid - 1) / mid;
            }
            if (sum > threshold) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
