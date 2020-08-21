package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/20 11:14 上午
 * @description
 */
public class Jian42 {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int curr = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            //和当前比，只要比当前小直接重置为当前
            curr = Math.max(nums[i], nums[i] + curr);
            res = Math.max(curr, res);
        }
        return res;
    }
}
