package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/20 11:25 上午
 * @description
 */
public class Jian44 {
    public int findNthDigit(int n) {
        if (n < 10) {
            return n;
        }
        int count = 0;
        int power = 1;
        while (true) {
            //取当前位数对应的，每一位上的计数
            if (power == 1) {
                count = 10;
            } else {
                count = (int) (Math.pow(10, power - 1) * 9 * power);
            }
            if (count > n) {
                break;
            }
            n -= count;
            power++;
        }
        int res = (int) (Math.pow(10, power - 1) + n / power);
        return String.valueOf(res).charAt(n / power) - '0';
    }
}
