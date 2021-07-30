package LeetCode;

public class leetcode566 {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        if (m * n != r * c) {
            return mat;
        }
        int[][] num = new int[r][c];
        int index = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++, index++) {
                num[i][j] = mat[index / n][index % n];
            }
        }
        return num;
    }
}
