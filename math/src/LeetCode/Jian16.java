package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/16 10:50 下午
 * @description
 */
public class Jian16 {
    public double myPow(double x, int n) {
        double res = 1;
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        //将为奇数时多个那个x 直接乘到res中
        while (n != 0) {
//            if((n&1)==1)
            if (n % 2 == 1) {
                res *= x;
            }
            x *= x;
            n /= 2;
        }
        return res;
    }
}
