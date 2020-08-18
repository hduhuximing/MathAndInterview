package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/17 3:27 下午
 * @description
 */
public class leetcode7 {
    public int reverse(int x) {
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x /= 10;
        }
        return (int) res == res ? (int) res : 0;
    }
}
