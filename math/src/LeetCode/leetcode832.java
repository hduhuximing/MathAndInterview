package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/9/9 12:19 下午
 * @description
 */
public class leetcode832 {
    public int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            reverse(A[i]);
        }
        return A;
    }

    private void reverse(int[] arr) {
        int i = 0;
        int j = arr.length-1;
        while (i <= j) {
            int temp = arr[i];
            arr[i] = arr[j] == 0 ? 1 : 0;
            arr[j] = temp == 0 ? 1 : 0;
            i++;
            j--;
        }
    }
}
