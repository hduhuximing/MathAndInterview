package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/20 2:21 下午
 * @description
 */
public class Jian53_1 {
    //找到最左边和最右边
    public int search(int[] nums, int target) {
        int left = helpL(nums, target);
        if (left == -1) {
            return 0;
        }
        int right = helpR(nums, target);
        return right - left + 1;
    }

    //返回下标,最左边的
    public int helpL(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        int index = -1;
        while (i <= j) {
            int mid = (j - i) / 2 + i;
            if (nums[mid] >= target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
            if (nums[mid] == target) {
                index = mid;
            }
        }
        return index;

    }

    public int helpR(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        int index = -1;
        while (i <= j) {
            int mid = (j - i) / 2 + i;
            if (nums[mid] <= target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
            if (nums[mid] == target) {
                index = mid;
            }
        }
        return index;
    }
}
