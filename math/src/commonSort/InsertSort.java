package commonSort;

import java.util.Arrays;

/**
 * 平均时间复杂度 O(n^2)
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] arr = new int[]{5, 3, 2, 8, 5, 9, 1, 0};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //插入排序
    public static void insertSort(int[] arr) {
        //遍历所有的数字前一个大
        //取当前值，如果当前比前一个小，直接将当前保存，前面的向后走一步
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                int temp = arr[i];
                int j;
                for (j = i; j > 0; j--) {
                    if (temp < arr[j - 1]) {
                        arr[j] = arr[j - 1];
                    }else{
                        break;
                    }
                }
                arr[j] = temp;
            }
        }
    }

    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j);
                } else {
                    break;
                }
            }

        }
    }
    private static void swap(int[] arr, int j) {
        int temp = arr[j];
        arr[j] = arr[j - 1];
        arr[j - 1] = temp;
    }
}
