package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/20 11:18 上午
 * @description 1的个数，剥离高位
 */
public class Jian43 {
    public int countDigitOne(int n) {
        return dfs(n);
    }

    private int dfs(int n) {
        if (n <= 0) {
            return 0;
        }
        String num = String.valueOf(n);
        int high = num.charAt(0) - '0';
        int pow = (int) Math.pow(10, num.length() - 1);
        int last = n - high * pow;
        if (high == 1) {
            return dfs(pow - 1) + 1 + dfs(last)+last;
        } else {
            return pow + high * dfs(pow - 1) + dfs(last);
        }
    }
}
