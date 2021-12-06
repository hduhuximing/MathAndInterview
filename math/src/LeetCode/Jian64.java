package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/20 3:45 下午
 * @description
 */
public class Jian64 {
    public int sumNums(int n) {
        boolean flag = (n != 0) && (n += sumNums(n - 1)) > 0;
        return n;
    }
}
