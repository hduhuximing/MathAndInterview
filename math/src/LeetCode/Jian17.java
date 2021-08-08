package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/18 8:57 下午
 * @description
 */
public class Jian17 {
    public int[] printNumbers(int n) {
        if (n < 0) {
            return new int[0];
        }
        //先求10的n次方
        int base = 10;
        int res = 1;
        while (n != 0) {
            if ((n & 1) == 1) {
                res *= base;
            }
            base *= base;
            n /= 2;
        }
        //正序输出
        int[] nums = new int[res - 1];
        int index = 0;
        while (index < res - 1) {
            nums[index++] = index;
        }
        return nums;
    }
}
