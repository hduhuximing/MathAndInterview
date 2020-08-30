package LeetCode;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/25 2:00 下午
 * @description
 */
public class leetcode1299 {
    public int[] replaceElements(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new int[0];
        }
        int max = arr[arr.length - 1];
        arr[arr.length - 1] = -1;
        for (int i = arr.length - 2; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = max;
            max = Math.max(max, temp);
        }
        return arr;
    }
}
