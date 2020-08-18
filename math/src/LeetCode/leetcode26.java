package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/15 1:16 下午
 * @description
 */
public class leetcode26 {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[index]) {
                nums[++index] = nums[i];
            }
        }
        return index + 1;
    }
}
