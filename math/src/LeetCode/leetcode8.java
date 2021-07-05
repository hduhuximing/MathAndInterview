package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2021/7/5 10:08 下午
 * @description
 */
public class leetcode8 {
    public int myAtoi(String str) {
        //去掉空格的情况
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        //取符号位
        int sign = 1;
        int index = 0;
        if (str.charAt(index) == '+') {
            index++;
        } else if (str.charAt(index) == '-') {
            index++;
            sign = -1;
        }
        //取数字
        long number = 0;
        for (; index < str.length(); index++) {
            if (str.charAt(index) < '0' || str.charAt(index) > '9') {
                break;
            }
            number = number * 10 + (str.charAt(index) - '0');
            //判断是否超过了范围
            if (number >= Integer.MAX_VALUE) {
                break;
            }
        }
        if (number * sign >= Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (number * sign <= Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) number * sign;
    }
}
