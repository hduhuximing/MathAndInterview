package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2022/1/15 7:36 PM
 * @description
 */
public class leetcode70 {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int pre = 1;
        int after = 2;
        int temp = 0;
        for (int i = 3; i <= n; i++) {
            temp = after;
            after = pre + after;
            pre = temp;
        }
        return after;
    }
}
