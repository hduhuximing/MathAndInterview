package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/19 3:43 下午
 * @description
 */
public class Jian29 {
    public int[] spiralOrder(int[][] matrix) {
        // ArrayList<Integer> list = new ArrayList<>();
        if (matrix.length == 0) {
            return new int[0];
        }
        int[] res = new int[matrix.length * matrix[0].length];
        int index = 0;
        int r1 = 0;
        int r2 = matrix.length - 1;
        int c1 = 0;
        int c2 = matrix[0].length - 1;
        while (r1 <= r2 && c1 <= c2) {
            //先走行
            for (int c = c1; c <= c2; c++) {
                // list.add(matrix[r1][c]);
                res[index++] = matrix[r1][c];
            }
            //走列
            for (int r = r1 + 1; r <= r2; r++) {
                // list.add(matrix[r][c2]);
                res[index++] = matrix[r][c2];

            }
            //判断当前边数 如果不是4条边就不用遍历了
            if (r1 < r2 && c1 < c2) {
                for (int c = c2 - 1; c > c1; c--) {
                    // list.add(matrix[r2][c]);
                    res[index++] = matrix[r2][c];

                }
                for (int r = r2; r > r1; r--) {
                    // list.add(matrix[r][c1]);
                    res[index++] = matrix[r][c1];

                }
            }
            r1++;
            r2--;
            c1++;
            c2--;
        }
        return res;
    }
}
