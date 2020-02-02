package commonSort;

import java.util.Arrays;

/**
 * 平均时间复杂度 O(nlogn)
 */
public class ShellSort {
    //希尔排序
    public static void main(String[] args) {
        int[] arr = new int[]{3, 5, 2, 7, 8, 1, 2, 0, 4, 7, 4, 3, 8};
        System.out.println(Arrays.toString(arr));
//        shellSort(arr);
        shaSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void shellSort(int[] arr) {
        int k = 1;
        // 遍历所有的步长,步长只要大于0就可以进行排序
        for (int d = arr.length / 2; d > 0; d /= 2) {
            // 遍历所有有元素
            for (int i = d; i < arr.length; i++) {
                // 遍历本组中所有的元素
                for (int j = i - d; j >= 0; j -= d) {
                    // 如果当前元素大于加上步长后的那个元素
                    if (arr[j] > arr[j + d]) {
                        //交换
                        swap1(arr, j, j + d);
                    }
                }
            }
            System.out.println("第" + k + "次排序结果：" + Arrays.toString(arr));
            k++;
        }
    }

    private static void swap1(int[] arr, int j, int i2) {
        int temp = arr[j];
        arr[j] = arr[i2];
        arr[i2] = temp;
    }

    public static void shaSort(int[] arr) {
        //步长
        for (int d = arr.length / 2; d > 0; d /= 2) {
            //获取当前位置元素
            //每次比较只和当前+d位置比较
            for (int i = d; i < arr.length; i++) {
                for (int j = i - d; j >= 0; j -= d) {
                    if (arr[j + d] < arr[j]) {

                        swap1(arr, j + d, j);
                    }
                }
            }
        }
    }

}
