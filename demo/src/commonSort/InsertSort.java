package commonSort;

import java.net.BindException;
import java.util.Arrays;

/**
 * 平均时间复杂度 O(n^2)
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] arr = new int[]{5, 3, 2, 8, 5, 9, 1, 0};
//        insertSort(arr);
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //插入排序
    public static void insertSort(int[] arr) {
        //遍历所有的数字
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                int temp = arr[i];
                int j;

                for (j = i; j > 0; j--) {
                    if (temp < arr[j - 1]) {
                        arr[j] = arr[j - 1];
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
//
//		for(int i=1;i<arr.length;i++) {
//			//如果当前数字比前一个数字小
//			if(arr[i]<arr[i-1]) {
//				//把当前遍历数字存起来
//				int temp=arr[i];
//				int j;
//				//遍历当前数字前面所有的数字
//				for(j=i-1;j>=0&&temp<arr[j];j--) {
//					//把前一个数字赋给后一个数字
//					arr[j+1]=arr[j];
//				}
//				//把临时变量（外层for循环的当前元素）赋给不满足条件的后一个元素
//				arr[j+1]=temp;
//			}
//		}
//	}

}
