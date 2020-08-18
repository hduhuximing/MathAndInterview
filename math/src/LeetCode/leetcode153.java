package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/18 7:02 下午
 * @description
 */
public class leetcode153 {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1 || nums[0] < nums[nums.length - 1]) {
            return nums[0];
        }
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int mid = (j - i) / 2 + i;
            if (nums[mid] == nums[j]) {
                j--;
            } else if (nums[mid] > nums[j]) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        return nums[i];
    }
}
