package commonSort;

import java.util.Arrays;

/**
 * @author ming
 * @version 1.0
 * @date 2020/1/16 1:47 下午
 */
//计数排序 范围性确定的
public class CountSort {
    public static void main(String[] args) {
        int[] arr = {2, 10, 4, 6, 8, 3, 5};
        //获取最大值，生成一个最大值数组。
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int[] result = sort(arr, max);
        System.out.println(Arrays.toString(result));
    }

    private static int[] sort(int[] arr, int max) {
        int[] result = new int[arr.length];
        int[] count = new int[max + 1];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        int j = 0;
        for (int i = 0; i < count.length; i++) {
            //循环当前位置数，如果大于0 进行插入。
            while (count[i]-- > 0) {
                result[j++] = i;
            }
        }
        return result;
    }
}
