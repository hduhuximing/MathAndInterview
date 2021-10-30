package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/16 10:31 下午
 * @description
 */
public class Jian13 {
    public int movingCount(int m, int n, int k) {
        //标注访问过了的数据，二维降为一维
        boolean[] flag = new boolean[m * n];
        return help(flag, m, n, 0, 0, k);
    }
    // m 总行数，n 总列数
    private int help(boolean[] flag, int m, int n, int i, int j, int k) {
        //跳出条件
        if (i < 0 || j < 0 || i >= m || j >= n || flag[i * n + j] || IsValid(i, j, k)) {
            return 0;
        }
        //本次是为了记录长度，不用回溯
        flag[i * n + j] = true;
        return 1 + help(flag, m, n, i + 1, j, k)
                + help(flag, m, n, i, j + 1, k)
                + help(flag, m, n, i - 1, j, k)
                + help(flag, m, n, i, j - 1, k);
    }

    //检测是否符合需求
    private boolean IsValid(int i, int j, int k) {
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
