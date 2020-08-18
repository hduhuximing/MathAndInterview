package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/16 2:50 下午
 * @description
 */
public class Jian14_2 {
    public int cuttingRope(int n) {
        if (n < 4) {
            return n - 1;
        }
        if (n == 4) {
            return 4;
        }
        long res = 1L;
        //计算有多少个3 多余的最后乘
        while (n > 4) {
            n -= 3;
            res = (res * 3) % 1000000007;
        }
        if (n != 0) {
            res = (res * n) % 1000000007;
        }
        return (int) res;
    }
}
