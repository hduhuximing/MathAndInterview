package commonSort;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = new int[]{25,84,21,47,15,27,68,35,20};
//        System.out.println(Arrays.toString(arr));
        mergeSort(arr, 0, arr.length - 1);
//        System.out.println(Arrays.toString(arr));
    }

    //归并
    public static void mergeSort(int[] arr, int start, int end) {
        int mid = (start + end) / 2;
        if (start < end) {
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            mergeHelper(arr, start, mid, end);
            System.out.println(Arrays.toString(arr));
        }
    }

    private static void mergeHelper(int[] arr, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int index = 0;
        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                temp[index++] = arr[i++];
            } else {
                temp[index++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[index++] = arr[i++];
        }
        while (j <= end) {
            temp[index++] = arr[j++];
        }
        for (int k = 0; k < temp.length; k++) {
            arr[start + k] = temp[k];
        }
    }

}
