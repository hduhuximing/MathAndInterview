package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/18 9:43 下午
 * @description
 */
public class Jian21 {
    public int[] exchange(int[] nums) {
        if (nums.length == 1) {
            return nums;
        }
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            //左边找到第一个偶数
            while (i < j && (nums[i] % 2 == 1)) {
                i++;
            }
            //右边找到第一个奇数
            while (i < j && (nums[j] % 2 == 0)) {
                j--;
            }
            //交换
            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        return nums;
    }
}
