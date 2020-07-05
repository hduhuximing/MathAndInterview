package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/7/5 11:15 上午
 * @description
 */
public class leetcode238 {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int len = nums.length;
        int[] res = new int[len];
        res[0] = 1;
        for (int i = 1; i < len; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int R = 1;
        for (int i = len - 1; i >= 0; i--) {
            res[i]=R*res[i];
            R*=nums[i];
        }
        return res;
    }
}
