package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/3/7 12:47 下午
 * @description 给定一个整数矩阵，找出最长递增路径的长度。
 * <p>
 * 对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外（即不允许环绕）。
 */
public class leetcode329 {
    int xLen;
    int yLen;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        xLen = matrix.length;
        yLen = matrix[0].length;
        int re = Integer.MIN_VALUE;
        int[][] res = new int[xLen][yLen];
        for (int i = 0; i < xLen; i++) {
            for (int j = 0; j < yLen; j++) {
                re = Math.max(help(matrix, res, i, j, Integer.MIN_VALUE), re);
            }
        }
        return re;
    }

    private int help(int[][] matrix, int[][] res, int i, int j, int pre) {
        if (i < 0
                || i >= matrix.length
                || j < 0
                || j >= matrix[0].length
                || matrix[i][j] <= pre) {
            return 0;
        }
        if (res[i][j] != 0) {
            return res[i][j];
        }
        res[i][j] = Math.max(
                Math.max(help(matrix, res, i - 1, j, matrix[i][j]),
                        help(matrix, res, i + 1, j, matrix[i][j])),
                Math.max(help(matrix, res, i, j - 1, matrix[i][j]),
                        help(matrix, res, i, j + 1, matrix[i][j]))) + 1;
        return res[i][j];
    }
}
