package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/9/27 7:30 下午
 * @description
 */
public class leetcode59 {
    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int r1 = 0;
        int r2 = n - 1;
        int c1 = 0;
        int c2 = n - 1;
        int index = 1;
        while (r1 <= r2 && c1 <= c2) {
            for (int i = c1; i <= c2; i++) {
                matrix[r1][i] = index++;
            }
            for (int j = r1 + 1; j <= r2; j++) {
                matrix[j][c2] = index++;
            }
            if (r1 < r2 && c1 < c2) {
                for (int t = c2 - 1; t > c1; t--) {
                    matrix[r2][t] = index++;
                }
                for (int k = r2; k > r1; k--) {
                    matrix[k][c1] = index++;
                }
            }
            r1++;
            r2--;
            c1++;
            c2--;
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] hel = generateMatrix(6);
        for (int i = 0; i < hel.length; i++) {
            for (int j = 0; j < hel[0].length; j++) {
                if(i==0){
                    System.out.print(hel[i][j]+" ,");
                }else{
                    System.out.print(hel[i][j]+",");
                }
            }
            System.out.println();
        }


    }
}
