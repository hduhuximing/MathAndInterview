package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/20 2:08 下午
 * @description
 */
public class Jian53_2 {
    public int missingNumber(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int mid = (j - i) / 2 + i;
            if (nums[mid] == mid) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return i;
    }
}
