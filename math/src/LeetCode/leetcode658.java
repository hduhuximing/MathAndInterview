package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ming
 * @version 1.0
 * @date 2020/8/17 6:50 下午
 * @description
 */
public class leetcode658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        int len = arr.length;
        int i = 0;
        int j = arr.length - 1;
        while (len > k) {
            if (Math.abs(arr[i] - x) > Math.abs(arr[j] - x)) {
                i++;
            } else {
                j--;
            }
            len--;
        }
        for (int l = i; l <= j; l++) {
            list.add(arr[l]);
        }
        return list;
    }
}
