package commonSort;

import java.util.Arrays;

public class HeapSort {
    //大顶堆选出最大的值，与最后的一个数交换，再次转为大顶堆。
    public static void main(String[] args) {
        int[] arr = new int[]{9, 6, 8, 7, 0, 1, 10, 4, 2};
//        heapSort(arr);
//        heSort(arr);
        hsort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void hsort(int[] arr) {
        for (int i = (arr.length - 1) / 2; i >= 0; i--) {
            maxhe(arr, arr.length, i);
        }
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, i, 0);
            maxhe(arr, i, 0);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void heSort(int[] arr) {
        //找到第一个父节点，大顶堆
        for (int i = (arr.length - 1) / 2; i >= 0; i--) {
            //从i节点向下比较
            maxhe(arr, arr.length, i);
        }
        for (int i = arr.length - 1; i > 0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            maxhe(arr, i, 0);
        }
    }

    private static void maxhe(int[] arr, int length, int i) {
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        //缓存最大值
        int max = i;
        if (left < length && arr[left] > arr[max]) {
            max = left;
        }
        if (right < length && arr[right] > arr[max]) {
            max = right;
        }
        if (max != i) {
            int temp = arr[max];
            arr[max] = arr[i];
            arr[i] = temp;
            maxhe(arr, length, max);
        }
    }

//
//    public static void heapSort(int[] arr) {
//        //开始位置是最后一个非叶子节点，即最后一个节点的父节点
//        //int start = (arr.length-1)/2;
//        //调整为大顶堆
//        for (int i = (arr.length - 1) / 2; i >= 0; i--) {
//            maxHeap(arr, arr.length, i);
//        }
//        //先把数组中的第0个和堆中的最后一个数交换位置
//        //再把前面的处理为大顶堆
//
//        for (int i = arr.length - 1; i > 0; i--) {
//
//
//            int temp = arr[0];
//            arr[0] = arr[i];
//            arr[i] = temp;
//            maxHeap(arr, i, 0);
//        }
//    }

//    public static void maxHeap(int[] arr, int size, int index) {
//        //左子节点
//        int leftNode = 2 * index + 1;
//        //右子节点
//        int rightNode = 2 * index + 2;
//        int max = index;
//        //和两个子节点分别对比，找出最大的节点
//        if (leftNode < size && arr[leftNode] > arr[max]) {
//            max = leftNode;
//        }
//        if (rightNode < size && arr[rightNode] > arr[max]) {
//            max = rightNode;
//        }
//        //交换位置
//        if (max != index) {
//            int temp = arr[index];
//            arr[index] = arr[max];
//            arr[max] = temp;
//            //交换位置以后，可能会破坏之前排好的堆，所以，之前的排好的堆需要重新调整
//            maxHeap(arr, size, max);
//        }
//    }

}
