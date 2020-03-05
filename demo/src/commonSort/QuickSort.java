package commonSort;

import java.util.Arrays;
import java.util.concurrent.Semaphore;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 6, 7, 2, 7, 2, 8, 0, 9, 1};
//		quickSort(arr,0,arr.length-1);
        quSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            //把数组中的第0个数字做为标准数
            int stard = arr[start];
            //记录需要排序的下标
            int low = start;
            int high = end;
            //循环找比标准数大的数和比标准数小的数
            while (low < high) {
                //右边的数字比标准数大
                while (low < high && stard <= arr[high]) {
                    high--;
                }
                //使用右边的数字替换左边的数
                arr[low] = arr[high];
                //如果左边的数字比标准数小
                while (low < high && arr[low] <= stard) {
                    low++;
                }
                arr[high] = arr[low];
            }
            //把标准数赋给低所在的位置的元素
            arr[low] = stard;
            //处理所有的小的数字
            quickSort(arr, start, low);
            //处理所有的大的数字
            quickSort(arr, low + 1, end);
        }
    }

    public static void quSort(int[] arr, int start, int end) {
        if (start < end) {
            int stand = arr[start];
            int low = start;
            int high = end;
            while (low < high) {
                while (low < high && stand <= arr[high]) {
                    high--;
                }
                arr[low] = arr[high];
                while (low < high && stand > arr[low]) {
                    low++;
                }
                arr[high] = arr[low];
            }
            arr[low] = stand;
            //左右两边分开
            quSort(arr, start, low);
            quSort(arr, low + 1, end);
        }
    }

}
