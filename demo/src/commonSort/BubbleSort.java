package commonSort;

import com.sun.org.apache.xpath.internal.operations.String;

import java.util.Arrays;
import java.util.List;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = new int[]{5, 7, 2, 9, 4, 1, 0, 5, 7};
        System.out.println(Arrays.toString(arr));
//        bubbleSort(arr);
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //冒泡排序

    /**
     * 5,7,2,9,4,1,0,5,7		共需要比较length-1轮
     * 5,7,2,9,4,1,0,5,7
     * 5,2,7,9,4,1,0,5,7
     * 5,2,7,4,1,0,5,7,9
     * 2,5
     */
    public static void bubbleSort(int[] arr) {
        //控制共比较多少轮
        for (int i = 0; i <= arr.length - 2; i++) {
            boolean flag = true;
            //控制比较的次数
            for (int j = 0; j <= arr.length - 2 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = false;
                }
            }
            //有序直接跳出结束
            if (flag) {
                break;
            }
        }
    }

    public static void sort(int[] arr) {
        //整体比较次数
        for (int i = arr.length - 1; i > 0; i--) {
            boolean flag = true;
            //每次都能找到一个最打的放到当前未排序数组的最后一位
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }

}
