package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/2/13 10:45 上午
 * @description
 */




public class leetcode152 {
    private int a=1;
    public static int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = nums[0];
        int min = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]<0) {
                max = Math.max(nums[i], nums[i] * max);
                min = Math.min(nums[i], min * nums[i]);
            } else {
                int temp = max;
                max = Math.max(nums[i], nums[i] * min);
                min = Math.max(nums[i], temp * nums[i]);
            }
            res = Math.max(max, res);
        }
        return res;
    }

    public static void main(String[] args) {
        int i = maxProduct(new int[]{2, 3, -2, 4});
        System.out.println(i);
    }
}
