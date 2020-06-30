package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/2/12 12:42 下午
 * @description
 */
public class leetcode41 {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        for (int i = 0; i < nums.length; ) {
            if (nums[i] > 0 && nums[i] < nums.length && nums[i] != nums[nums[i] - 1]) {
                int temp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[nums[i] - 1] = temp;
            } else {
                i++;
            }
        }
        int index = 0;
        while (index < nums.length && nums[index] == index + 1) {
            index++;
        }
        return index + 1;

    }
}
