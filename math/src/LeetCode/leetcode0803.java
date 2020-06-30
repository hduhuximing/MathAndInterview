package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/6/3 10:04 上午
 * @description
 */
public class leetcode0803 {
    private int res = -1;

    public int findMagicIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        search(nums, 0, nums.length - 1);
        return res;
    }

    private void search(int[] nums, int start, int end) {
        if (start > end) {
            return;
        }
        int mid = start + (end - start) / 2;
        if (nums[mid] == mid) {
            res = mid;
            search(nums, start, mid - 1);
        } else {
            search(nums, start, mid - 1);
            if (res == -1) {
                search(nums, mid + 1, end);
            }
        }
    }

}