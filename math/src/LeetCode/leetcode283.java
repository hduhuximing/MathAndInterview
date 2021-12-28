package LeetCode;

public class leetcode283 {
    public void moveZeroes(int[] nums) {
        if(nums.length==1){
            return;
        }
        int zero = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                zero++;
            } else {
                nums[i - zero] = nums[i];
                nums[i] = 0;
            }
        }
    }
}
