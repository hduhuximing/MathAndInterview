package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/20 2:37 下午
 * @description
 */
public class Jian56_1 {
    public int[] singleNumbers(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int[] res = new int[2];
        int arr = 0;
        for (int i = 0; i < nums.length; i++) {
            arr ^= nums[i];
        }
        int seq = 1;
        while ((seq & arr) ==0) {
            seq = seq << 1;
        }
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & seq) == 0) {
                res[0] ^= nums[i];
            } else {
                res[1] ^= nums[i];
            }
        };
        return res;
    }
}
