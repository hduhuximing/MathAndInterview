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
        int[] arr = new int[len];
        int i = 0;
        int j = len - 1;
        int index = len-1;
        while (index >= 0) {
            int left = A[i] * A[i];
            int right = A[j] * A[j];
            if (left > right) {
                arr[index--] = left;
                i++;
            } else {
                arr[index--] = right;
                j--;
            }
        }
        return arr;
    }
}
