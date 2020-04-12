package commonSort;

import com.sun.org.apache.xpath.internal.operations.String;

import java.util.Arrays;
/**
 * @author ming
 * @version 1.0
 * @date 2020/1/16 1:47 下午
 * @descirption 平均O(n^2) 最好O(n)
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = new int[]{5, 7, 2, 9, 4, 1, 0, 5, 7};
        System.out.println(Arrays.toString(arr));
        bubbleSort(arr);
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
}
