package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/20 10:44 上午
 * @description
 */
public class Jian39 {
    public int majorityElement(int[] nums) {
        int res = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == res) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    res = nums[i];
                    count = 1;
                }
            }
        }
        return res;
    }
}
