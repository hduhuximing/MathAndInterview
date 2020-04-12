package offer;

import java.util.Scanner;

/**
 * @author ming
 * @version 1.0
 * @date 2020/4/8 9:35 下午
 * @description
 */
public class shudu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int[][] a = new int[9][9];
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    a[i][j] = sc.nextInt();
                }
            }
            dfs(a, 0);
            for (int[] b : a) {
                for (int c : b) {
                    System.out.print(c + " ");
                }
                System.out.println();
            }
        }
    }

    public static boolean dfs(int[][] a, int id) {
        if (id == 81) {
            return true;
        }
        int m = id / 9;
        int n = id % 9;
        if (a[m][n] == 0) {
            for (int i = 1; i < 10; i++) {
                if (!numberIsOK(a, m, n, i)) {
                    continue;
                }
                a[m][n] = i;
                if (dfs(a, id + 1)) {
                    return true;
                }
                a[m][n] = 0;
            }
        } else {
            return dfs(a, id + 1);
        }
        return false;
    }

    public static boolean numberIsOK(int[][] a, int m, int n, int t) {
        for (int i = 0; i < 9; i++) {
            if (a[m][i] == t || a[i][n] == t) {   //横竖都不存在重复
                return false;
            }
        }
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                if (a[m / 3 * 3 + i][n / 3 * 3 + j] == t)
                    return false;
            }
        return true;
    }
}

