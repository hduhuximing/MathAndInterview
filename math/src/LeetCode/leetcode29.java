package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/9/1 8:06 下午
 * @description
 */
public class leetcode29 {
    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        if (divisor == 0) {
            return -1;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        //去符号位
        boolean negetive = (dividend ^ divisor) < 0;
        int res = 0;
        //当前循环的数量
        int count = 1;
        //变成long防止超范围
        long dividend_temp = Math.abs((long) dividend);
        long divisor_temp = Math.abs((long) divisor);
        while (dividend_temp >= divisor_temp) {
            dividend_temp -= divisor_temp;
            res += count;
            if (dividend_temp < Math.abs((long) divisor)) {
                break;
            }
            if (dividend_temp < divisor_temp * 2) {
                count = 1;
                divisor_temp = Math.abs((long) divisor);
                continue;
            }
            divisor_temp += divisor_temp;
            count += count;
        }
        return negetive ? -res : res;
    }
}
