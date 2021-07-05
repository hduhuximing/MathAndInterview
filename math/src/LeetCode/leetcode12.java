package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2021/7/5 10:23 下午
 * @description
 */
public class leetcode12 {
    public String intToRoman(int num) {
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder str = new StringBuilder();
        int index = 0;
        while (num != 0) {
            while (num >= nums[index]) {
                str.append(romans[index]);
                num -= nums[index];
            }
            index++;
        }
        return str.toString();
    }
}
