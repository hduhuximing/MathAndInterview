package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/15 1:40 下午
 * @description
 */
public class leetcode66 {
    public int[] plusOne(int[] digits) {
        int carry = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                carry = 1;
                digits[i] = 0;
            } else {
                digits[i]++;
                return digits;
            }
        }
        if (carry == 1) {
            digits = new int[digits.length + 1];
            digits[0] = 1;
        }
        return digits;
    }
}
