package commonSort;

import java.util.Arrays;

public class SelectSort {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 5, 7, 1, 2, 0, 3, 6, 8};
//        selectSort(arr);
        seleSort(arr);
        System.out.println(Arrays.toString(arr));


        String s="001";
        Integer integer = Integer.valueOf(s);
        System.out.println(integer);

    }

    //选择排序，
    //每次从当前到后面选出一个最小的位置进行交换。
    public static void selectSort(int[] arr) {
        //遍历所有的数
        for (int i = 0; i <= arr.length - 2; i++) {
            int minIndex = i;
            //把当前遍历的数和后面所有的数依次进行比较，并记录下最小的数的下标
            for (int j = i + 1; j < arr.length; j++) {
                //如果后面比较的数比记录的最小的数小。
                if (arr[minIndex] > arr[j]) {
                    //记录下最小的那个数的下标
                    minIndex = j;
                }
            }

            //如果最小的数和当前遍历数的下标不一致,说明下标为minIndex的数比当前遍历的数更小。
            if (i != minIndex) {
                swap(arr, i, minIndex);
            }

        }
    }

    public static void seleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            //找到最小元素位置
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            //判断是否需要更新
            if (minIndex != i) {
                swap(arr, i, minIndex);
            }

        }
    }

    private static void swap(int[] arr, int i, int minIndex) {
        int temp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = temp;
    }
}
