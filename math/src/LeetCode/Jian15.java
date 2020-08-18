package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/16 10:49 下午
 * @description
 */
public class Jian15 {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }
}
