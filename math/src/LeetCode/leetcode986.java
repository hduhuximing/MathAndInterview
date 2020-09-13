package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ming
 * @version 1.0
 * @date 2020/9/4 11:50 上午
 * @description
 */
public class leetcode986 {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < A.length && j < B.length) {
            int a = Math.max(A[i][0], B[j][0]);
            int b = Math.min(A[i][1], B[j][1]);
              if (a <= b) {
                list.add(new int[]{a, b});
            }
            if (A[i][1] < B[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        return list.toArray(new int[list.size()][]);

    }
}
