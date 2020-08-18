package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/16 10:31 下午
 * @description
 */
public class Jian13 {
    public int movingCount(int m, int n, int k) {
        boolean[] flag = new boolean[m * n];
        return help(flag, m, n, 0, 0, k);
    }

    private int help(boolean[] flag, int m, int n, int i, int j, int k) {
        //跳出条件
        if (i < 0 || j < 0 || i >= m || j >= n || flag[i * n + j] || check(i, j, k)) {
            return 0;
        }
        flag[i * n + j] = true;
        return 1 + help(flag, m, n, i + 1, j, k)
                + help(flag, m, n, i, j + 1, k)
                + help(flag, m, n, i - 1, j, k)
                + help(flag, m, n, i, j - 1, k);
    }

    private boolean check(int i, int j, int k) {
        int sum = 0;
        while (i != 0) {
            sum += i % 10;
            i /= 10;
        }
        while (j != 0) {
            sum += j % 10;
            j /= 10;
        }
        return sum > k;
    }
}
