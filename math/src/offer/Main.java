package offer;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        long i = 1;
        long j = 1;
        List<Long> list = new ArrayList<>();
        list.add(i);
        list.add(j);
        for (int k = 3; k <= num * num; k++) {
            long sum = i + j;
            i = j;
            j = sum;
            list.add(sum);
        }
        System.out.println(list.toString());
        Collections.reverse(list);
        long[][] matrix = new long[num][num];
        int index = 0;
        int r1 = 0;
        int r2 = num - 1;
        int c1 = 0;
        int c2 = num - 1;
        while (r1 <= r2 && c1 <= c2) {
            //先走行
            for (int c = c1; c <= c2; c++) {
                // list.add(matrix[r1][c]);
                matrix[r1][c] = list.get(index++);
            }
            //走列
            for (int r = r1 + 1; r <= r2; r++) {
                // list.add(matrix[r][c2]);
                matrix[r][c2] = list.get(index++);

            }
            //判断当前边数 如果不是4条边就不用遍历了
            if (r1 < r2 && c1 < c2) {
                for (int c = c2 - 1; c > c1; c--) {

                    matrix[r2][c] = list.get(index++);

                }
                for (int r = r2; r > r1; r--) {
                    matrix[r][c1] = list.get(index++);

                }
            }
            r1++;
            r2--;
            c1++;
            c2--;
        }
        for (int k = 0; k < matrix.length; k++) {
            StringBuilder str = new StringBuilder();
            for (int l = 0; l < matrix[0].length; l++) {
                str.append(matrix[k][l] + " ");
            }
            System.out.println(str.toString().trim());
        }
    }
}
