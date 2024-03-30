package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/16 10:50 下午
 * @description
 */
public class Jian16 {
    public double myPow(double x, int n) {
        long N = n;
        double res = 1;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        //将为奇数时多个那个x 直接乘到res中
        while (N != 0) {
//            if((n&1)==1)
            if (N % 2 == 1) {
                res *= x;
            }
            x *= x;
            N /= 2;
        }
        return res;
    }
}
