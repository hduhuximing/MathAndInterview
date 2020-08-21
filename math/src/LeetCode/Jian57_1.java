package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/20 2:55 下午
 * @description
 */
public class Jian57_1 {
    public int[] twoSum(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum > target) {
                j--;
            } else if (sum < target) {
                i++;
            } else {
                return new int[]{nums[i], nums[j]};
            }
        }
        return new int[0];
    }
}
