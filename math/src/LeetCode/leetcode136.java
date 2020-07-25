package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/7/22 7:43 下午
 * @description
 */
public class leetcode136 {
    public int singleNumber(int[] nums) {
        int len = nums.length;
        int res = nums[0];
        for (int i = 0; i < len; i++) {
            res = res ^ nums[i];
        }
        return res;
    }
}
