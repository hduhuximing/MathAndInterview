package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/9/9 12:50 下午
 * @description
 */
public class leetcode162 {
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[mid + 1])
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }
}
