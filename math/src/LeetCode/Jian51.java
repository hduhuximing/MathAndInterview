package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/20 1:43 下午
 * @description
 */
public class Jian51 {
    public int reversePairs(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return 0;
        }
        return help(nums, 0, len - 1);
    }

    private int help(int[] nums, int i, int j) {
        if (i >= j) {
            return 0;
        }
        int mid = (j - i) / 2 + i;
        int left = help(nums, i, mid);
        int right = help(nums, mid + 1, j);
        if (nums[mid] <= nums[mid + 1]) {
            return left + right;
        }
        return merge(nums, i, mid, j) + left + right;
    }

    private int merge(int[] nums, int i, int mid, int j) {
        if (i >= j) {
            return 0;
        }
        int[] temp = new int[j - i + 1];
        int start1 = i;
        int start2 = mid + 1;
        int index = 0;
        int res = 0;
        while (start1 <= mid && start2 <= j) {
            res += nums[start1] > nums[start2] ? mid - start1 + 1 : 0;
            temp[index++] = nums[start1] <= nums[start2] ? nums[start1++] : nums[start2++];
        }
        while (start1 <= mid) {
            temp[index++] = nums[start1++];
        }
        while (start2 <= j) {
            temp[index++] = nums[start2++];
        }
        for (int k = 0; k < temp.length; k++) {
            nums[i + k] = temp[k];
        }
        return res;
    }
}
