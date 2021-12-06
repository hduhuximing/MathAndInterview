package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/20 3:46 下午
 * @description
 */
public class Jian65 {

    public int add(int a, int b) {
        int sum = 0;
        int next = 0;
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }
        while (b != 0) {
            sum = a ^ b;
            next = (a & b) << 1;
            a = sum;
            b = next;
        }
        return a;
    }


    public int add1(int a, int b) {
        int sum = 0;
        int next = 0;
        if (a == 0) {
            return b;
        } else if (b == 0) {
            return a;
        }
        while (b != 0) {
            sum = a ^ b;
            next = (a & b) << 1;
            a = sum;
            b = next;
        }
        return sum;
    }
}
