package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/16 7:15 下午
 * @description
 */
public class leetcode977 {
    public int[] sortedSquares(int[] A) {
        int len = A.length;
        int[] arr = new int[A.length];
        int start = 0;
        int end = len - 1;
        int index = A.length - 1;
        while (index >= 0) {
            int left = A[start] * A[start];
            int right = A[end] * A[end];
            if (left >= right) {
                arr[index--] = left;
                start++;
            } else {
                arr[index--] = right;
                end--;
            }
        }
        return arr;
    }
}
