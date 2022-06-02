package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/7/5 8:19 下午
 * @description
 */
public class leetcode169 {
    public int majorityElement(int[] nums) {
        int len = nums.length;
        int count = 1;
        int curr = nums[0];
        //计数，与之前数据一致 count++，否则--，先判断是否count为0
        for (int i = 1; i < len; i++) {
            if (count != 0) {
                if (curr == nums[i]) {
                    count++;
                } else {
                    count--;
                }
            } else {
                count = 1;
                curr = nums[i];
            }
        }
        return curr;
    }
}
