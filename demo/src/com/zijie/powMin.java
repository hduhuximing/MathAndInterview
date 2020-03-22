package com.zijie;

/**
 * @author ming
 * @version 1.0
 * @date 2020/3/11 11:14 上午
 * @description
 */
public class powMin {
    public static int squareNotEqual(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int left = 0;
        int right = arr.length - 1;
        int count = 0;
        int pre = Integer.MIN_VALUE;
        while (left <= right) {
            while (left <= right && Math.abs(arr[left]) == pre) {
                left++;
            }
            while (left <= right && Math.abs(arr[right]) == pre) {
                right--;
            }
            if (left <= right) {
                count++;
                if (Math.abs(arr[left]) > Math.abs(arr[right])) {
                    pre = Math.abs(arr[left]);
                    left++;
                } else {
                    pre = Math.abs(arr[right]);
                    right--;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {-1, -1, -1, 1, 1, 1, 2};
        int ans = squareNotEqual(arr);
        System.out.println(ans);
    }
}
