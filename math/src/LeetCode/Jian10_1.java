package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/13 6:34 下午
 * @description
 */
public class Jian10_1 {
    public int fib(int n) {
        if (n == 1 || n == 0) {
            return n;
        }
        long pre = 0;
        long curr = 1;
        for (int i = 2; i <= n; i++) {
            long temp = curr;
            curr = (pre + curr) % 1000000007;
            pre = temp;
        }
        return (int)curr;

    }
}
