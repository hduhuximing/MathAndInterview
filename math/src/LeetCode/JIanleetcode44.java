package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/3/19 8:47 下午
 * @description 数字以0123456789101112131415…的格式序列化到一个字符序列中。
 * 在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
 * <p>
 * 请写一个函数，求任意第n位对应的数字。
 * 示例 1：
 * <p>
 * 输入：n = 3
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：n = 11
 * 输出：0
 */
public class JIanleetcode44 {
    public int findNthDigit(int n) {
        if (n < 10) {
            return n;
        }
        int count = 0;
        int power = 1;
        while (true) {
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
        return String.valueOf(res).charAt(n % power) - '0';
    }
}
