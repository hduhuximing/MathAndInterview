package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/13 6:14 下午
 * @description
 */
public class Jian3 {
    public int findRepeatNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            while (i != nums[i]) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }
}
